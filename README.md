# Oauth2.0 Authorization server

## Authorization server
> port 8080

schema.sql 참고
1. oauth_client_details 테이블 생성
2. oauth_client_details 에 client 생성
3. user 테이블 생성
4. UserRepositoryTest 실행하여 유저 생성
5. AuthApplication 실행하여 토큰 발급 테스트 진행
    - GET
      ```
      localhost:8080/oauth/authorize?client_id=testClientId&redirect_uri=http://localhost:8080/oauth2/callback&response_type=code&scope=read
      ```
    - Test 에서 생성한 id와 password 입력
    - redirect uri로 이동되면 Authorize 버튼 클릭
    - 토큰 발급 성공

## Resource server
> port 8081

1. Authorization server 에서 발급받은 토큰을 활용하여 요청을 보내야함
    - GET http://localhost:8081/v1/users
    - header: 
      - name : Authorization
      - value : bearer {토큰 값}
      - ex) 
        - ```
          bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NDIwMzQ3NDIsInVzZXJfbmFtZSI6ImVrZmhhMjJAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImp0aSI6ImEzNmUyYWE0LTlkM2QtNDk4Ni1iMjMwLTI4OWFmYThlY2Q2MSIsImNsaWVudF9pZCI6InRlc3RDbGllbnRJZCIsInNjb3BlIjpbInJlYWQiXX0.92RvfV53PzObVzv5UJulYo6GeVykB6rgXpJd7mJ_yvs
          ```
2. 인증된 유저라고 판단하여 모든 사용자의 정보가 출력되면 성공