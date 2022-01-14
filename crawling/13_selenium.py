from selenium import webdriver
import time

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

browser = webdriver.Chrome("D:/visualStudioWorkspace/crawling/chromedriver.exe")

# 1. 네이버 이동
browser.get("http://naver.com") # naver.com 으로 접속

# 2. 로그인 버튼 클릭
elem = browser.find_element_by_class_name("link_login")
elem.click()

# 3. id, pw 입력
browser.find_element_by_id("id").send_keys("naver_id")
browser.find_element_by_id("pw").send_keys("password")

# 4. 로그인 버튼 클릭
browser.find_element_by_id("log.login").click()

time.sleep(3)

# 5. id 를 새로 입력
browser.find_element_by_id("id").clear()
browser.find_element_by_id("id").send_keys("my_id")

# 6. html 정보 출력
print(browser.page_source)

# 7. 브라우저 종료
# browser.close()
browser.quit()