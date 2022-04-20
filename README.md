# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
-- --
## 기능 목록
* **기능 목록**
    * 게임
        * 시작
        * 실행
            * 실행 결과
        * 종료
    * 자동차
        * 이름
            * 사용자 입력
        * 상태
            * 전진
            * Random
                * 4 이상일 경우 전진
                * 3 이하일 경우 멈춤
    * 우승
        * 단독 우승
        * 공동 우승
    * 예외
        * 명확한 유형을 처리
        * '[ERROR]' 로 시작하는 에러 메세지 출력
        * '[ERROR]' 메세지 출력한 부분부터 입력을 다시 받음
            * Application은 끝나지 않음
                * 예외 handling 필요
        * IllegalArgumentException
            * 사용자가 잘못 된 값을 입력할 경우
                * 자동차 이름 입력
                    * 5자 이상의 값을 입력
                    * 경주 자동차가 입력되지 않음
                * 시도할 횟수 입력
                    * Number type이 아닌 값을 입력
                    * 0 미만의 값을 입력
        * IllegalStateException
            * 사용자가 잘못 된 값을 입력한 경우
                * 자동차 이름 입력
                    * 경주 자동차가 한개만 입력 된 경우
                    * 중복된 값을 입력

-- --
## 참고 사항
* 2주차 추가 요구사항
    * [**일급콜렉션을 활용해 구현한다**](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
    * [**모든 원시값과 문자열을 포장한다**](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4)
* **Library**
    * **Java**
        * JDK 8 사용할 것
        * JDK의 Random(), Scanner() 사용 금지
        * JDK 8의 stream api 사용 금지
        * lambda 사용 가능
        * camp.nextstep.edu.missionutils.Randoms.pickNumberInRange() 사용 —> 랜덤 값 추출
        * camp.nextstep.edu.missionutils.Console.readLine() 사용 —> 사용자 입력
    * **Test**
        * [JUnit5](https://www.baeldung.com/parameterized-tests-junit-5) , [AssertJ 사용](https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion)
* **Test**
    * baseBall.ApplicationTest 의 2개 Test Case 성공
        * 별도 Test Case 생성 가능
    * Doamin Logic 단위 테스트 구현
        * UI 로직 제외
* **[Java Code Convention](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)**
    * indent, depth 는 2를 넘지 않도록 구현
    * else 문 사용 금지
    * switch/case 사용 금지
    * method 길이는 10라인을 넘지 않는다
        * Method가 한 가지 기능을 하도록 한다
* **Git**
    * **Commit**
        * **[Commit Message Convension](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)**
        * README에 정리한 기능 목록 단위로 Commit