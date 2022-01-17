from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
browser = webdriver.Chrome("D:/visualStudioWorkspace/crawling/chromedriver.exe")
browser.maximize_window() # 창 최대화

url = "https://flight.naver.com/"
browser.get(url) # url 이동

# 가는 날 클릭
xpath = "//button[text()='가는 날']"
browser.find_element_by_xpath(xpath).click()

# 달력이 열릴때까지 대기
import time
time.sleep(1)

# 이번 달 22일, 23일 선택
# xpath = "//b[text()='22']"
# browser.find_elements_by_xpath(xpath)[0].click() # [0] -> 이번 달
# xpath = "//b[text()='23']"
# browser.find_elements_by_xpath(xpath)[0].click() # [0] -> 이번 달

# 다음 달 22일, 23일 선택
# xpath = "//b[text()='22']"
# browser.find_elements_by_xpath(xpath)[1].click() # [1] -> 다음 달
# xpath = "//b[text()='23']"
# browser.find_elements_by_xpath(xpath)[1].click() # [1] -> 다음 달

# 이번 달 22일, 다음달 23일 선택
xpath = "//b[text()='22']"
browser.find_elements_by_xpath(xpath)[0].click() # [0] -> 이번 달
xpath = "//b[text()='23']"
browser.find_elements_by_xpath(xpath)[1].click() # [1] -> 다음 달

# from 부산
browser.find_element_by_xpath("//*[@id='__next']/div/div[1]/div[4]/div/div/div[2]/div[1]/button[1]").click()
time.sleep(1)
xpath = "//button[text()='국내']"
browser.find_element_by_xpath(xpath).click()
time.sleep(1)
xpath = "//i[contains(text(), '부산')]"
browser.find_element_by_xpath(xpath).click()

# to 제주
browser.find_element_by_xpath("//*[@id='__next']/div/div[1]/div[4]/div/div/div[2]/div[1]/button[2]").click()
time.sleep(1)
xpath = "//button[text()='국내']"
browser.find_element_by_xpath(xpath).click()
time.sleep(1)
xpath = "//i[contains(text(), '제주')]"
browser.find_element_by_xpath(xpath).click()

# 항공권 검색
browser.find_element_by_xpath("//*[@id='__next']/div/div[1]/div[4]/div/div/button").click()
try:
    elem = WebDriverWait(browser, 10).until(EC.presence_of_element_located((By.XPATH, "//*//*[@id='__next']/div/div[1]/div[4]/div/div[2]/div[2]/div")))
    # 성공했을 때 동작 수행
    print(elem.text) # 첫번째 결과 출력
finally:
    while(True):
        pass
    # browser.quit()