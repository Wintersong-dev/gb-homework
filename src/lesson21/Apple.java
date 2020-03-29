package lesson21;

public class Apple extends Fruit {
    private float weight;
    Apple() {
        weight = 1.0f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
