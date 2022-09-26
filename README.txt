H2 DB 사용 (주소 : jdbc:h2:tcp://localhost/~/test)

초반 데이터 스크립트 위치 : 루트 디렉토리 -> resources -> data.sql

스웨거 접속 URL : http://localhost:8080/swagger-ui.html

API 서버 구동 방법 :

처음 DbHomeWorkApplication.java -> main 함수를 빌드한 후

H2 데이터베이스를 띄운 후, resources -> data.sql의 내용을 실행하여 DB에 ID: admin/ PW: admin 데이터를 삽입한다.

그 후, 스웨거를 띄워서 auth-controller에서 /api/authenticate API를 실행(
                                                          {
                                                            "password": "admin",
                                                            "username": "admin"
                                                          }
                                                          하여 인증을 진행한다.

인증된 토큰이 있으면 my-room-controller에 있는 API들을 실행하여 DB에 데이터가 들어가는지 또는 정상적으로 조회되는지 확인할 수 있다.
