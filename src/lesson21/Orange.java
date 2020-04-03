package lesson21;

public class Orange extends Fruit {
    private float weight;
    Orange() {
        weight = 1.5f;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
