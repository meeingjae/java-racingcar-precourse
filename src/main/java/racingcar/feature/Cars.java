package racingcar.feature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private final Map<Player, Score> car = new HashMap<>();

    public Cars(List<Player> player) {
        player.forEach(this::addPlayer);
    }

    public void progressAll(int count) {
        for (int i = 0; i < count; i++) {
            calculateScore();
            printProgress();
        }
    }

    public void printWinner() {
        List<String> winner = new ArrayList<>();

        //TODO: 우승자 출력 구현
        // score 갯수가 가장 많은 사람이 우승
        // cars 내부에 있는 모든 score의 갯수를 구해야함
        // 실제 print 필요한 값은 Key 값. 즉 Player 이다
        // Score.getScoreCount()

        // 판별 데이터는 Score , 출력 데이터는 Players

        System.out.println("최종 우승자 : " + String.join(" ", winner));
    }

    private void addPlayer(Player player) {
        //일급 컬렉션이고 add하는 method이지만 불변을 보장한다. 왜냐. addPlayer 메소드를 캡슐화 하여, 생성자에서만 해당 메소드를 호출하기 때문
        car.put(player, new Score());
    }

    //TODO: 메소드명 고민
    private void calculateScore() {
        for (Player player : car.keySet()) {
            // random generator가 4 이상이어야 전진이라는 것은 비즈니스 로직이다. 해당 로직에 대한 책임은 누구에게 있는가?
            car.put(player, car.get(player).stopOrAdvance());
        }
    }

    private void printProgress() {
        car.forEach((player, score) -> System.out.println(player.toString() + " : " + score.toString()));
    }
}
