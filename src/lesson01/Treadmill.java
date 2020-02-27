package lesson01;

public class Treadmill implements Obstacle {

    int distance;

    Treadmill(int _distance) {
        distance = _distance;
    }
    @Override
    public boolean override(Athlete a) {
        boolean res = true;

        if (a.run() < distance) {
            System.out.println("Пациент споткнулся и упал.");
            res = false;
        } else {
            System.out.println("Атлет превозмог все " + distance + " метров.");
        }
        return res;
    }
}
