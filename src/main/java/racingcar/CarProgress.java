package racingcar;

public class CarProgress {

    private static final String bar = "-";
    private int count;

    public int getCount() {

        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void plusProgress() {
        this.count++;
    }

    public String getProgressBar() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(bar);
        }
        return builder.toString();
    }
}
