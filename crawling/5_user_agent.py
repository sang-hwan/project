# 출처: https://www.youtube.com/watch?v=yQ20jZwDjTE&t=1035s&ab_channel=%EB%82%98%EB%8F%84%EC%BD%94%EB%94%A9

import requests
url = "http://nadocoding.tistory.com"
# what-is-my-user-agent로 user-agent 확인
headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36"}
res = requests.get(url, headers=headers)
res.raise_for_status()
with open("nadocoding.html", "w", encoding="utf-8") as f:
    f.write(res.text)