package racingcar;

public class Car {
    private final CarName carName;
    private final CarProgress carProgress;

    public Car(CarName carName, CarProgress carProgress) {
        this.carName = carName;
        this.carProgress = carProgress;
    }

    public String getCarName() {
        return this.carName.getName();
    }

    public int getProgressCount() {
        return this.carProgress.getCount();
    }

    public String getCarProgressBar() {
        return this.carProgress.getProgressBar();
    }

    public void plusProgress() {
        this.carProgress.plusProgress();
    }

    public String getStatus() {
        return this.carName.getName() + " : " + this.carProgress.getProgressBar();
    }
}
