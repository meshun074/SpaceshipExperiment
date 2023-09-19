public class U2Rocket extends Rocket{
    public U2Rocket()
    {
        super(18000,29000);
    }
    public int getCost() {
        int cost;
        cost = 120;
        return cost;
    }
    public boolean launch()
    {
        float prob= 4/100f * ( (float) getWeight() /getMax_weight());
        return prob>=0.035;
    }
    public boolean land()
    {
        float prob= 8/100f * ( (float) getWeight() /getMax_weight());
        return prob>=0.074;
    }
}
