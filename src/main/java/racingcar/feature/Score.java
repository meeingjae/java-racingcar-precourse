package racingcar.feature;

public class Score {
    private static final String INITIALIZE_SCORE = "";
    private static final String ADVANCE = "-";

    private static final int SCORE_RANGE_MIN = 0;
    private static final int SCORE_RANGE_MAX = 9;
    private static final int ADVANCE_SCORE = 4;

    private String score;

    public Score() {
        this.score = INITIALIZE_SCORE;
    }

    public Score stopOrAdvance() {
        RandomGenerator generator = new RandomGenerator(new Number(SCORE_RANGE_MIN), new Number(SCORE_RANGE_MAX));
        if (generator.generate() >= ADVANCE_SCORE) {
            this.score += ADVANCE;
        }
        return this;
    }

    public int getScoreCount() {
        return score.toCharArray().length;
    }
}
