package lesson01;

public class Robot implements Athlete {
    private String name;
    private int distance;
    private int height;

    Robot(String _name, int _distance, int _height) {
        name = _name;
        distance = _distance;
        height = _height;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int run() {
        System.out.print("Робот по имени " + name + " пытается бежать... ");
        return distance;
    }

    @Override
    public int jump() {
        System.out.print("Робот по имени " + name + " пытается прыгнуть... ");
        return height;
    }
}
