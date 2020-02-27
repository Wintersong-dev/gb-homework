package lesson01;

public class Main {
    public static void main(String[] args) {
        Athlete[] athletes = new Athlete[6];
        athletes[0] = new Human("Иван", 200, 50); // 200 метров запас хода, 50 см высота прыжка
        athletes[1] = new Human("Петр", 250, 80); // 250 метров запас хода, 80 см высота прыжка
        athletes[2] = new Cat("Барсик", 100, 90); // 100 метров запас хода, 90 см высота прыжка
        athletes[3] = new Cat("Мурзик", 150, 120); // 150 метров запас хода, 120 см высота прыжка
        athletes[4] = new Robot("Бендер", 150, 30); // 150 метров запас хода, 30 см высота прыжка (не особо спортивный)
        athletes[5] = new Robot("Кейд-6", 400, 90); // 400 метров запас хода, 90 см высота прыжка

        Obstacle[] obstacles = new Obstacle[6];
        obstacles[0] = new Wall(40);
        obstacles[1] = new Treadmill(90);
        obstacles[2] = new Wall(50);
        obstacles[3] = new Treadmill(140);
        obstacles[4] = new Wall(60);
        obstacles[5] = new Treadmill(180);

        boolean res;
        for (Athlete a : athletes) {
            res = true; // Полон решимости

            for (Obstacle o : obstacles) {
                res = o.override(a);

                if (!res) {
                    System.out.println("Бедняга потирает ушибленное и тихонько отползает.");
                    System.out.println("");
                    break;
                }
            }

            if (res) {
                System.out.println("В неравной борьбе со стенками и беговыми дорожками, " + a.getName() + " с честью выдержал все испытания!");
                System.out.println("");
            }
        }
    }
}
