public class Rocket implements SpaceShip{
    private int weight;
    private final int max_weight;

    public Rocket(int weight, int max_weight) {
        this.weight = weight;
        this.max_weight = max_weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMax_weight() {
        return max_weight;
    }


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return weight + item.getWeight() <= max_weight;
    }

    @Override
    public void carry(Item item) {
        setWeight(getWeight()+item.getWeight());
    }
}
