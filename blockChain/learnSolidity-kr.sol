
// 먼저, 간단한 은행 컨트랙트입니다.
// 입금, 출금, 예금 조회가 가능합니다

// simple_bank.sol (.sol 확장자를 사용합니다)
/* **** 샘플 시작 **** */

// 소스에 컴파일러 버전을 선언합니다.
pragma solidity ^0.4.22;

// Natspec 주석으로 시작합니다 (세 개의 슬래시)
// 문서화, 혹은 UI 요소 / 동작에 대한 설명 데이터로 사용됩니다.

/// @title SimpleBank
/// @author nemild

/* 'contract'는 다른 언어의 'class'와 비슷합니다. (클래스 변수, 상속 등) */
contract SimpleBank { // 카멜 표기법
    // 함수 밖에서 선언된 상태 변수는 컨트랙의 생애 주기 동안 저장됩니다.

    // 주소와 예금을 매핑하는 딕셔너리
    // overflow 공격을 항상 조심해야 합니다.
    mapping (address => uint) private balances;

    // "private"은 다른 컨트랙트가 직접적으로 예금을 질의할 수 없다는 것을 의미합니다.
    // 하지만 블록체인에서 여전히 데이터를 확인할 수 있습니다.

    address public owner;
    // 'public'은 외부 유저나 컨트랙이 읽을 수 있다는 의미입니다. (쓰는 것은 별개)

    // 이벤트 - 외부 리스너들에게 공개된 액션
    event LogDepositMade(address accountAddress, uint amount);

    // 생성자는 하나 혹은 여러개의 변수를 인자로 받을 수 있습니다.
    constructor() public {
        // msg는 컨트랙트에 전달된 메시지에 대한 정보를 담고 있습니다.
        // msg.sender는 컨트랙 호출자입니다. (여기선 컨트랙 생성자의 주소)
        owner = msg.sender;
    }

    /// @notice 은행에 이더를 예금
    /// @return 예금이 완료된 후 변화된 유저의 예금
    function deposit() public payable returns (uint) {
        // 'require'를 유저의 입력값을 검사하는데 사용하고, 'assert'를 내부 요소 검사에 사용하세요
        // 여기선, overflow 이슈가 없음을 보장하기 위해 사용합니다.
        require((balances[msg.sender] + msg.value) >= balances[msg.sender]);

        balances[msg.sender] += msg.value;
        // 상태 변수에는 "this."나 "self." 키워드가 필요하지 않습니다.
        // 모든 값은 기본적으로 데이터 타입의 초기 값으로 지정됩니다

        LogDepositMade(msg.sender, msg.value); // 이벤트 발생

        return balances[msg.sender];
    }

    /// @notice 은행에서 이더 출금
    /// @dev 초과한 이더를 반환하지 않습니다.
    /// @param withdrawAmount 출금하고 싶은 양
    /// @return 유저에게 남은 예금
    function withdraw(uint withdrawAmount) public returns (uint remainingBal) {
        require(withdrawAmount <= balances[msg.sender]);

        // 우리가 보내기 전에 예금을 바로 감소시키는 것에 주목하세요.
        // 컨트랙에서의 모든 .transfer/.send 는 외부 함수를 호출할 수 있습니다.
        // 이는 호출자가 가지고 있는 예금보다 더 많은 양을 재진입을 통해 요청할 수 있게 합니다
        // .transfer/.send 를 포함한 외부 함수 호출 전에 상태를 변경하는 것을 목표로 하세요.
        balances[msg.sender] -= withdrawAmount;

        // 이 구문은 실패시 자동으로 throw합니다. 이는 변경된 예금이 복귀됨을 의미합니다.
        msg.sender.transfer(withdrawAmount);

        return balances[msg.sender];
    }

    /// @notice 예금 조회
    /// @return 유저의 예금
    // 'constant'는 함수를 상태 변수를 변경하지 못하게 막아줍니다.
    // 오프체인 혹은 네트워크와 관계없이 함수를 실행하게 합니다.
    function balance() constant public returns (uint) {
        return balances[msg.sender];
    }
}
// ** 샘플 끝 **


// 이제 솔리디티의 기초입니다.

// 1. 데이터 타입과 메소드
// uint는 돈의 양 (double, float는 없습니다) 혹은 날짜 (unix time)를 위해 사용합니다.
uint x;

// 256 bits의 int가 초기화 이후엔 변경이 불가능합니다.
int constant a = 8;
int256 constant a = 8; // 256이 명시되어 있을 뿐 위와 마찬가지 구문입니다.
uint constant VERSION_ID = 0x123A1; // hex 상수입니다.
// 'constant' 키워드는 컴파일러가 각각의 실제 값으로 변경합니다.

// 모든 상태 변수는 기본적으로 내부 함수만 접근가능한 'internal'입니다.
// 그리고 모든 컨트랙트는 상속만을 받을 수 있습니다.
// 외부 컨트랙이 접근 가능하게 하기 위해선 명시적으로 'public'를 선언해야합니다.
int256 public a = 8;

// int와 uint는, 명시적으로 8에서 256까지 선언할 수 있습니다.
// 예를 들어, int8, int16, int24
uint8 b;
int64 c;
uint248 e;

// overflow가 발생하지 않도록 주의하세요. 또한, 그러한 취약점에 대한 방어를 하세요
// 예를 들어, 덧셈 연산에서는, 다음과 같이 작성하세요:
uint256 c = a + b;
assert(c >= a); // 내부 요소에 대한 assert 테스트입니다. require은 유저 입력값일 경우 사용합니다.
// 또 다른 일반적인 연산 이슈는 Zeppelin 사의 SafeMath 라이브러리를 참고하세요.
// https://github.com/OpenZeppelin/zeppelin-solidity/blob/master/contracts/math/SafeMath.sol


// 다른 컨트랙 혹은 자체적인 랜덤 함수를 만들어 사용하지 마세요.

// 타입 캐스팅
int x = int(b);

bool b = true; // 혹은 'var b = true;' 을 통해 타입 추론할 수 있습니다.

// 주소 - 이더리움 주소는 20 byte/160 bit 입니다
// 연산은 허용되지 않습니다.
address public owner;

// account 종류:
// Contract account: 생성 시 만들어지는 주소 (생성자의 주소, 트랜잭션 번호)
// External Account: (사람/외부 집단): public key를 통해 생성

// 'public' 키워드를 통해 필드를 외부에서 접근가능 하도록 할 수 있습니다.
// getter는 자동으로 생성되지만 setter는 생성되지 않습니다.

// 모든 주소는 이더를 전송할 수 있습니다.
owner.transfer(SOME_BALANCE); // 실패 시에 원상복구됩니다.

// 더 lower level인 .send 를 호출 할 수 있습니다. 실패 시에 false를 반환합니다.
if (owner.send) {} // 명심할 것: 'if'절 안에 send를 감싸더라도, 컨트랙 주소가
// 실행한 함수 내 send가 항상 성공하는 것은 아니라는 점
// 또한, 전송 전에 잔고를 변경해 재진입 공격에 대한 위험을 줄일 것

// 잔고를 확인할 수 있습니다.
owner.balance; // 유저의 잔고 (유저 혹은 컨트랙트)


// Byte는 1에서 32까지 가능합니다.
byte a; // byte는 bytes1과 동일합니다.
bytes2 b;
bytes32 c;

// 동적 사이즈의 bytes
bytes m; // 특별한 배열, byte[] 배열과 같습니다
// byte1-byte32 보다 비싸므로 가능한 피합니다.

// 바이크와 같지만 길이나 인덱스를 통한 접근은 불가능합니다.
string n = "hello"; // UTF8로 저장되며, '가 아닌 '"를 사용합니다
// string 유틸리티 함수가 추후 추가될 예정입니다.
// UTF8이 더 많은 공간을 필요로 하므로 bytes32/bytes를 선호합니다.

// 타입 유추
// var 은 첫번째 연산을 통해 타입을 유추합니다.
// 함수의 인자로는 사용할 수 없습니다
var a = true;
// 잘못된 타입을 유추할 수 있기 때문에 조심해야합니다.
// 예를 들어, int16이 필요할 때 int8로 유추될 수 있습니다.

// var는 함수를 변수에 대입할 때 사용될 수 있습니다.
function a(uint x) returns (uint) {
    return x * 2;
}
var f = a;
f(22); // 호출

// 모든 값은 기본적으로 초기화 시에 0이 연산됩니다.

// Delete는 대부분의 타입에 사용될 수 있습니다.
// (value를 없애는 것이 아니라 초기값인 0을 대입합니다.)
uint x = 5;


// Destructuring/Tuples
(x, y) = (2, 7); // 복수 개의 값을 대입/변경


// 2. 자료 구조
// 배열
bytes32[5] nicknames; // 정적 배열
bytes32[] names; // 동적 배열
uint newLength = names.push("John"); // 새로운 길이의 배열을 반환
// 길이
names.length; // 길이를 참조
names.length = 1; // 길이도 대입할 수 있습니다 (storage 속 동적 배열에 한해서 가능합니다.)

// 고차원 배열
uint x[][5]; // 5 개의 동적 원소를 가진 배열

// 사전 (특정 타입 - 특정 타입)
mapping (string => uint) public balances;
balances["charles"] = 1;
console.log(balances["ada"]); // 0 반환, 모든 입력이 안된 값은 0을 반환합니다.
// 'public'은 다른 컨트랙이 아래의 구문을 실행할 수 있게 합니다.
contractName.balances("charles"); // 1 반환
// 'public'은 아래와 같은 getter를 선언합니다. (setter는 제외):
function balances(string _account) returns (uint balance) {
    return balances[_account];
}

// Nested 매핑
mapping (address => mapping (address => uint)) public custodians;

// 삭제를 위해선
delete balances["John"];
delete balances; // 모든 요소를 0으로 대입합니다.

// 다른 언어오 다르게 key 없이 모든 mapping의 모든 요소를 순회할 수 없습니다.
// 따로 자료 구조를 만들어 동작하도록 해야합니다.

// 구조체
struct Bank {
    address owner;
    uint balance;
}
Bank b = Bank({
    owner: msg.sender,
    balance: 5
});
// 혹은
Bank c = Bank(msg.sender, 5);

c.balance = 5; // 새로운 값 대입
delete b;
// 매핑을 제외한 구조체 속 모든 변수에 초기값 0을 대입

// Enums
enum State { Created, Locked, Inactive }; // state machine에 종종 사용됩니다.
State public state; // enum으로 부터 변수를 선언합니다.
state = State.Created;
// enums은 명시적으로 int로 형 변환이 가능합니다.
uint createdState = uint(State.Created); //  0

// 데이터 저장소: 메모리 vs. 스토리지 vs. calldata - 모든 복잡한 자료구조 (배열,
// 구조체)는 데이터 저장소가 존재합니다.
// 'memory'는 영구적이지 않습니다. 'storage'는 영구적입니다.
// 로컬 변수와 상태 변수의 기본값은 'storage'입니다. 함수 파라미터는 'memory'입니다.
// 작은 로컬 변수는 스택이 담당합니다.

// 대부분의 타입의 경우 어느 데이터 저장소에 선언할 건지 명시할 수 있습니다.


// 3. 간단한 연산자
// 비교 연산자, 비트 연산자, 수학 연산자가 제공됩니다.
// 제곱: **
// exclusive or: ^
// bitwise negation: ~


// 4. 전역 변수
// ** this **
this; // 컨트랙의 주소
// 컨트랙을 더 이상 사용하지 않을 때 남은 잔고를 전송하기 위해 종종 사용됩니다.
this.balance;
this.someFunction(); // 내부 jump가 아닌 외부 call을 통해 함수를 실행합니다.

// ** msg - 컨트랙이 받는 메시지 ** **
msg.sender; // 전송자의 주소
msg.value; // 컨트랙에 전송된 이더의 값 (단위는 wei), 함수는 "payable"로 명시되어야 합니다.
msg.data; // bytes, 호출 시 데이터 전체
msg.gas; // 남은 gas

// ** tx - 트랜잭션 **
tx.origin; // 트랜잭션 생성자의 주소 값
tx.gasprice; // 트랜잭션의 단위 가스 값

// ** block - 현재 블록의 정보 **
now; // 현재의 대략적인 시간, block.timestamp와 같다 (Unix time을 사용합니다)
// 마이너에 의해 변경될 수 있으므로 주의합니다

block.number; // 현재의 블록 번호
block.difficulty; // 현재의 블록 난이도
block.blockhash(1); // bytes32를 반환합니다, 최근 256 blocks에 대해서만 동작합니다.
block.gasLimit();

// ** storage - 영구적인 스토리지 해시 **
storage['abc'] = 'def'; // 256 bit words와 256 bit words


// 4. 함수와 나머지
// A. 함수
// 단순 함수
function increment(uint x) returns (uint) {
    x += 1;
    return x;
}

// 함수는 여러 인자를 반환할 수 있습니다. 또한 반환 인자를 명확히하면 명시적 return이 필요 없습니다.
function increment(uint x, uint y) returns (uint x, uint y) {
    x += 1;
    y += 1;
}
// 위 함수를 실행
uint (a,b) = increment(1,1);

// 'constant' ('view'와 같음)
// 함수가 영구적인 변수를 변경하지 않는다는 것을 의미합니다.
// 상수 함수는 블록체인과 관계없이 실행 가능합니다.
uint y = 1;

function increment(uint x) constant returns (uint x) {
    x += 1;
    y += 1; // 이 구문은 실패합니다.
    // y는 상태 변수로 상수 함수에서 변경될 수 없습니다.
}

// 'pure'는 'constant'보다 더 엄격합니다. 상태 변수의 조회조차 불가능합니다.
// 실제 규칙은 더 복잡하므로 constant/pure와 관련해서는 다음 링크를 참고하세요:
// http://solidity.readthedocs.io/en/develop/contracts.html#view-functions

// '함수 Visibility 키워드'
// 'constant' 자리에 다음의 키워드를 입력할 수 있습니다:
// public - 외부 혹은 내부에서 확인 가능 (함수의 기본)
// external - 외부에서만 확인 가능 (호출도 가능합니다)
// private - 현재의 컨트랙트에서만 확인 가능
// internal - 현재의 컨트랙트와 상속된 컨트랙트에서만 확인 가능

// 모든 함수에 명시적으로 선언하는 것이 좋습니다.

// Functions hoisted - 변수에 함수를 대입할 수 있습니다.
function a() {
    var z = b;
    b();
}

function b() {

}

// 이더를 받는 모든 함수는 'payable'를 입력해야 합니다.
function depositEther() public payable {
    balances[msg.sender] += msg.value;
}


// 반복에는 loops를 활요합니다. (최대 스택 깊이는 1024입니다.)
// 또한 제한 없는 루프는 가스 제한에 걸리므로 사용하지 마세요.

// B. Events
// Events are notify external parties; easy to search and
// access events from outside blockchain (with lightweight clients)
// typically declare after contract parameters

// Typically, capitalized - and add Log in front to be explicit and prevent confusion
// with a function call

// 선언
event LogSent(address indexed from, address indexed to, uint amount); // 첫글자는 대문자입니다.

// 함수 실행
LogSent(from, to, amount);

// 외부에서 이벤트를 확인하기 위해서 Web3 Javascript 라이브러리를 사용합니다:
Coin.LogSent().watch({}, '', function(error, result) {
    if (!error) {
        console.log("Coin transfer: " + result.args.amount +
            " coins were sent from " + result.args.from +
            " to " + result.args.to + ".");
        console.log("Balances now:\n" +
            "Sender: " + Coin.balances.call(result.args.from) +
            "Receiver: " + Coin.balances.call(result.args.to));
    }
}
// Common paradigm for one contract to depend on another (e.g., a
// contract that depends on current exchange rate provided by another)

// C. Modifiers
// Modifiers validate inputs to functions such as minimal balance or user auth;
// similar to guard clause in other languages

// '_' (underscore)는 함수 본문 마지막에 추가됩니다. 이는 실행된 함수가 그곳에 있어야함을 의미합니다.
modifier onlyAfter(uint _time) { require (now >= _time); _; }
modifier onlyOwner { require(msg.sender == owner) _; }
// 주소 사용되는 스테이트 머신
modifier onlyIfStateA (State currState) { require(currState == State.A) _; }

// 함수 선언 바로 뒤에 붙여줍니다
function changeOwner(newOwner)
onlyAfter(someTime)
onlyOwner()
onlyIfState(State.A)
{
    owner = newOwner;
}

// underscore는 함수 이전에 추가될 수동 있습니다.
// 하지만 명시적인 반환에는 무시될 수 있으니 조심해서 사용해야 합니다.
modifier checkValue(uint amount) {
    _;
    if (msg.value > amount) {
        uint amountToRefund = amount - msg.value;
        msg.sender.transfer(amountToRefund);
    }
}


// 6. BRANCHING AND LOOPS

// All basic logic blocks work - including if/else, for, while, break, continue
// return - but no switch

// Syntax same as javascript, but no type conversion from non-boolean
// to boolean (comparison operators must be used to get the boolean val)

// For loops that are determined by user behavior, be careful - as contracts have a maximal
// amount of gas for a block of code - and will fail if that is exceeded
// For example:
for(uint x = 0; x < refundAddressList.length; x++) {
    refundAddressList[x].transfer(SOME_AMOUNT);
}

// Two errors above:
// 1. A failure on transfer stops the loop from completing, tying up money
// 2. This loop could be arbitrarily long (based on the amount of users who need refunds), and
// therefore may always fail as it exceeds the max gas for a block
// Instead, you should let people withdraw individually from their subaccount, and mark withdrawn
// e.g., favor pull payments over push payments


// 7. OBJECTS/CONTRACTS

// A. Calling external contract
contract InfoFeed {
    function info() returns (uint ret) { return 42; }
}

contract Consumer {
    InfoFeed feed; // points to contract on blockchain

    // Set feed to existing contract instance
    function setFeed(address addr) {
        // automatically cast, be careful; constructor is not called
        feed = InfoFeed(addr);
    }

    // Set feed to new instance of contract
    function createNewFeed() {
        feed = new InfoFeed(); // new instance created; constructor called
    }

    function callFeed() {
        // final parentheses call contract, can optionally add
        // custom ether value or gas
        feed.info.value(10).gas(800)();
    }
}

// B. 상속

// Order matters, last inherited contract (i.e., 'def') can override parts of
// previously inherited contracts
contract MyContract is abc, def("a custom argument to def") {

// Override function
    function z() {
        if (msg.sender == owner) {
            def.z(); // call overridden function from def
            super.z(); // call immediate parent overridden function
        }
    }
}

// abstract function
function someAbstractFunction(uint x);
// cannot be compiled, so used in base/abstract contracts
// that are then implemented

// C. Import

import "filename";
import "github.com/ethereum/dapp-bin/library/iterable_mapping.sol";


// 8. OTHER KEYWORDS

// A. Selfdestruct
// selfdestruct current contract, sending funds to address (often creator)
selfdestruct(SOME_ADDRESS);

// removes storage/code from current/future blocks
// helps thin clients, but previous data persists in blockchain

// Common pattern, lets owner end the contract and receive remaining funds
function remove() {
    if(msg.sender == creator) { // Only let the contract creator do this
        selfdestruct(creator); // Makes contract inactive, returns funds
    }
}

// May want to deactivate contract manually, rather than selfdestruct
// (ether sent to selfdestructed contract is lost)


// 9. CONTRACT DESIGN NOTES

// A. Obfuscation
// All variables are publicly viewable on blockchain, so anything
// that is private needs to be obfuscated (e.g., hashed w/secret)

// Steps: 1. Commit to something, 2. Reveal commitment
keccak256("some_bid_amount", "some secret"); // commit

// call contract's reveal function in the future
// showing bid plus secret that hashes to SHA3
reveal(100, "mySecret");

// B. Storage optimization
// Writing to blockchain can be expensive, as data stored forever; encourages
// smart ways to use memory (eventually, compilation will be better, but for now
// benefits to planning data structures - and storing min amount in blockchain)

// Cost can often be high for items like multidimensional arrays
// (cost is for storing data - not declaring unfilled variables)

// C. Data access in blockchain
// Cannot restrict human or computer from reading contents of
// transaction or transaction's state

// While 'private' prevents other *contracts* from reading data
// directly - any other party can still read data in blockchain

// All data to start of time is stored in blockchain, so
// anyone can observe all previous data and changes

// D. Cron Job
// Contracts must be manually called to handle time-based scheduling; can create external
// code to regularly ping, or provide incentives (ether) for others to

// E. Observer Pattern
// An Observer Pattern lets you register as a subscriber and
// register a function which is called by the oracle (note, the oracle pays
// for this action to be run)
// Some similarities to subscription in Pub/sub

// This is an abstract contract, both client and server classes import
// the client should implement
contract SomeOracleCallback {
    function oracleCallback(int _value, uint _time, bytes32 info) external;
}

contract SomeOracle {
    SomeOracleCallback[] callbacks; // array of all subscribers

    // Register subscriber
    function addSubscriber(SomeOracleCallback a) {
        callbacks.push(a);
    }

    function notify(value, time, info) private {
        for(uint i = 0;i < callbacks.length; i++) {
            // all called subscribers must implement the oracleCallback
            callbacks[i].oracleCallback(value, time, info);
        }
    }

    function doSomething() public {
        // Code to do something

        // Notify all subscribers
        notify(_value, _time, _info);
    }
}

// Now, your client contract can addSubscriber by importing SomeOracleCallback
// and registering with Some Oracle

// F. State machines
// see example below for State enum and inState modifier


// *** EXAMPLE: A crowdfunding example (broadly similar to Kickstarter) ***
// ** START EXAMPLE **

// CrowdFunder.sol
pragma solidity ^0.4.19;

/// @title CrowdFunder
/// @author nemild
contract CrowdFunder {
    // Variables set on create by creator
    address public creator;
    address public fundRecipient; // creator may be different than recipient
    uint public minimumToRaise; // required to tip, else everyone gets refund
    string campaignUrl;
    byte constant version = 1;

    // Data structures
    enum State {
        Fundraising,
        ExpiredRefund,
        Successful
    }
    struct Contribution {
        uint amount;
        address contributor;
    }

    // State variables
    State public state = State.Fundraising; // initialize on create
    uint public totalRaised;
    uint public raiseBy;
    uint public completeAt;
    Contribution[] contributions;

    event LogFundingReceived(address addr, uint amount, uint currentTotal);
    event LogWinnerPaid(address winnerAddress);

    modifier inState(State _state) {
        require(state == _state);
        _;
    }

    modifier isCreator() {
        require(msg.sender == creator);
        _;
    }

    // Wait 24 weeks after final contract state before allowing contract destruction
    modifier atEndOfLifecycle() {
    require(((state == State.ExpiredRefund || state == State.Successful) &&
        completeAt + 24 weeks < now));
        _;
    }

    function CrowdFunder(
        uint timeInHoursForFundraising,
        string _campaignUrl,
        address _fundRecipient,
        uint _minimumToRaise)
        public
    {
        creator = msg.sender;
        fundRecipient = _fundRecipient;
        campaignUrl = _campaignUrl;
        minimumToRaise = _minimumToRaise;
        raiseBy = now + (timeInHoursForFundraising * 1 hours);
    }

    function contribute()
    public
    payable
    inState(State.Fundraising)
    returns(uint256 id)
    {
        contributions.push(
            Contribution({
                amount: msg.value,
                contributor: msg.sender
            }) // use array, so can iterate
        );
        totalRaised += msg.value;

        LogFundingReceived(msg.sender, msg.value, totalRaised);

        checkIfFundingCompleteOrExpired();
        return contributions.length - 1; // return id
    }

    function checkIfFundingCompleteOrExpired()
    public
    {
        if (totalRaised > minimumToRaise) {
            state = State.Successful;
            payOut();

            // could incentivize sender who initiated state change here
        } else if ( now > raiseBy )  {
            state = State.ExpiredRefund; // backers can now collect refunds by calling getRefund(id)
        }
        completeAt = now;
    }

    function payOut()
    public
    inState(State.Successful)
    {
        fundRecipient.transfer(this.balance);
        LogWinnerPaid(fundRecipient);
    }

    function getRefund(uint256 id)
    inState(State.ExpiredRefund)
    public
    returns(bool)
    {
        require(contributions.length > id && id >= 0 && contributions[id].amount != 0 );

        uint256 amountToRefund = contributions[id].amount;
        contributions[id].amount = 0;

        contributions[id].contributor.transfer(amountToRefund);

        return true;
    }

    function removeContract()
    public
    isCreator()
    atEndOfLifecycle()
    {
        selfdestruct(msg.sender);
        // creator gets all money that hasn't be claimed
    }
}
// ** END EXAMPLE **

// 10. OTHER NATIVE FUNCTIONS

// Currency units
// Currency is defined using wei, smallest unit of Ether
uint minAmount = 1 wei;
uint a = 1 finney; // 1 ether == 1000 finney
// Other units, see: http://ether.fund/tool/converter

// Time units
1 == 1 second
1 minutes == 60 seconds

// Can multiply a variable times unit, as units are not stored in a variable
uint x = 5;
(x * 1 days); // 5 days

// Careful about leap seconds/years with equality statements for time
// (instead, prefer greater than/less than)

// Cryptography
// All strings passed are concatenated before hash action
sha3("ab", "cd");
ripemd160("abc");
sha256("def");

// 11. SECURITY

// Bugs can be disastrous in Ethereum contracts - and even popular patterns in Solidity,
// may be found to be antipatterns

// See security links at the end of this doc

// 12. LOW LEVEL FUNCTIONS
// call - low level, not often used, does not provide type safety
successBoolean = someContractAddress.call('function_name', 'arg1', 'arg2');

// callcode - Code at target address executed in *context* of calling contract
// provides library functionality
someContractAddress.callcode('function_name');


// 13. STYLE NOTES
// Based on Python's PEP8 style guide
// Full Style guide: http://solidity.readthedocs.io/en/develop/style-guide.html

// Quick summary:
// 4 spaces for indentation
// Two lines separate contract declarations (and other top level declarations)
// Avoid extraneous spaces in parentheses
// Can omit curly braces for one line statement (if, for, etc)
// else should be placed on own line


// 14. NATSPEC COMMENTS
// used for documentation, commenting, and external UIs

// Contract natspec - always above contract definition
/// @title Contract title
/// @author Author name

// Function natspec
/// @notice information about what function does; shown when function to execute
/// @dev Function documentation for developer

// Function parameter/return value natspec
/// @param someParam Some description of what the param does
/// @return Description of the return value
