from selenium import webdriver

# 출처: https://www.youtube.com/watch?v=yQ20jZwDjTE&t=1035s&ab_channel=%EB%82%98%EB%8F%84%EC%BD%94%EB%94%A9

browser = webdriver.Chrome("D:/visualStudioWorkspace/crawling/chromedriver.exe")
browser.get("http://naver.com") # naver.com 으로 접속

# elem = browser.find_element_by_class_name("link_login") // class name 에 따른 태그 정보
# elem.click() // 가져온 elem 클릭
# browser.back() // 뒤로가기
# browser.forward() // 앞으로
# browser.refresh() // 새로고침
# elem = browser.find_element_by_id("query") // id name 에 따른 태그 정보
# from selenium.webdriver.common.keys import Keys // Keys import
# elem.send_keys("나도코딩") // input 태그에 value 입력
# elem.send_keys(Keys.ENTER) // input 태그에 ENTER 입력
# elem.browser.find_element_by_tag_name("a") // tag name 에 따른 태그 정보
# elem.browser.find_elements_by_tag_name("a") // 해당 page 의 목표 tag name 을 가진 모든 태그 정보
# for e in elem: // 모든 태그 정보의 href 속성 값
#   e.get_attribute("href")
# elem = browser.find_element_by_xpath("//*[@id='daumSearch']/fieldset/div/div/button[2]") // xpath 에 따른 태그 정보
# browser.close() // browser tab 종료
# browser.quit() // browser 종료