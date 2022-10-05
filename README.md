# 자동차 경주 게임
## 게임 목표
### 자동차 이름과, 게임 진행 횟수를 입력 받아 승자를 구한다
-- --
## 기능 요구사항
* `자동차`
  * `이름`
  * `상태`
* `게임`
  * 사용자 입력
    * 자동차 이름
      * 쉼표로 구분
    * 시도할 횟수
  * 게임 진행
    * 자동차의 상태를 변경
      * 0~3 : 멈춤
      * 4~9 : 전진
    * 시도할 횟수만큼 반복
    * 자동차 이름 출력
    * 자동차 상태 출력
  * 게임 결과    
    * 단독 우승자, 공동 우승자 안내 문구 출력
* `예외 상황`
  * 자동차 이름 입력
    * 자동차 이름이 입력되지 않았을 경우
    * 자동차 이름을 하나만 입력한 경우
    * 중복된 자동차 이름을 입력한 경우
    * 5자 이상의 자동차 이름을 입력한 경우
  * 시도할 횟수 입력
    * 시도할 횟수가 입력되지 않았을 경우
    * 숫자가 아닌 형태의 입력
    * 0 이하의 숫자 입력
    

* `사용자 입력에 대한 예외 처리`
  * 예외 상황 발생 시 `[ERROR]`로 시작하는 메세지 출력 후  재입력
  * 명확한 예외 유형을 처리한다
  * 예외 상황 발생 시 IllegalArgumentException 발생
-- --
## 참고 사항
* 2주차 추가 요구사항
    * [**일급콜렉션을 활용해 구현한다**](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_/)
        * [개인 블로그 포스팅](https://far-ming.tistory.com/3)
    * [**모든 원시값과 문자열을 포장한다**](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4)
      * [개인 블로그 포스팅](https://far-ming.tistory.com/4?category=1054121)
* **Library**
    * **Java**
        * JDK 8 사용할 것
        * JDK의 Random(), Scanner() 사용 금지
        * JDK 8의 stream api 사용 금지
        * lambda 사용 가능
        * camp.nextstep.edu.missionutils.Randoms.pickNumberInRange() 사용
        * camp.nextstep.edu.missionutils.Console.readLine() 사용
    * **Test**
        * [JUnit5](https://www.baeldung.com/parameterized-tests-junit-5) , [AssertJ 사용](https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#exception-assertion)
* **Test**
    * racinggame.ApplicationTest 의 2개 Test Case 성공
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

-- --
## 1주차 피드백

### 1. 이름을 통해 의도를 드러내라
> 변수 이름, 함수(메소드) 이름, 클래스 이름을 짓는데 시간을 투자하라.
### 2. 축약하지 마라
> 의도를 드러낼 수 있으면 이름이 길어져도 좋다.
### 3. 개발 도구의 code format 기능을 활용해라
### 4. space(공백)도 convention이다
### 5. 불필요하게 공백 라인을 만들지 않는다
### 6. 구현 순서도 convention이다
> class A {
>
>   상수(static final) 또는 클래스 변수
>
>   인스턴스 변수
>
>   생성자
>
>   메소드
>
> }
### 7. 중복은 소프트웨어에서 모든 악의 근원이다
### 8. 들여쓰기에 space와 tab을 혼영하지 않는다
### 9. 의미없는 주석은 달지 않는다
> 변수와 메소드의 이름을 통해 의도를 드러내도록 하고, 그 것이 어려운 경우 주석을 달도록 한다
### 10. 값을 하드코딩하지 마라
> 상수를 만들고 이름을 부여해 그 것의 역할이 무엇인지 의도를 드러내라
### 11. git commit 메세지를 의미 있게 작성
### 12. 기능 목록 업데이트
> README에 작성한 기능 목록은 구현하면서 언제든 변경될 수 있다
> 기능을 구현하면서 변경되는 부분을 항상 업데이트 해야한다
> 죽은 문서가 아니라 살아있는 문서를 만들자
### 13. 기능 목록 구현을 재검토한다
> 기능 목록을 클래스 설계와 구현, 메소드 설계와 구현과 같이 너무 상세하게 적지 않는다
> 세세한 부분을 정리하기 보다,구현해야할 기능 목록을 정리하는 데 집중한다
> 예외적인 상황도 기능 목록에 정리한다
### 14. README.md를 상세히 작성
> 해당 프로젝트가 어떤 프로젝트이며, 어떤 기능을 담고 있는지 기술하기 위해 markdown 문법을 검색해서 학습해보고 적용해본다