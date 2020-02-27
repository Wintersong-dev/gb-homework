package lesson01;

public class Wall implements Obstacle {
    int height;

    Wall(int _height) {
        height = _height;
    }
    @Override
    public boolean override(Athlete a) {
        boolean res = true;

        if (a.jump() < height) {
            System.out.println("Пациент не справился и впечатался в стену.");
            res = false;
        } else {
            System.out.println("Атлету удалось покорить высоту в " + height + " сантиметров.");
        }
        return res;
    }
}
