package year2023.day6;

public class Boat {

    long totalTime;
    long record;

    public Boat(long totalTime, long record) {
        this.totalTime = totalTime;
        this.record = record;
    }

    public int calculateWaysToBeatRecord() {
        int counter = 0;
        int speed = 1;

        while (speed < totalTime) {
            long distance = getDistance(speed);

            if (distance > record) {
                counter++;
            }
            speed++;
        }

        return counter;
    }

    private long getDistance(int speed) {
        long time = totalTime - speed;
        return time * speed;
    }
}
