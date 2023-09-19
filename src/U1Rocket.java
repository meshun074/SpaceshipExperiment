public class U1Rocket extends Rocket{
    public U1Rocket()
    {
        super(10000,18000);
    }

    public int getCost() {
        int cost;
        cost = 100;
        return cost;
    }

    @Override
    public boolean launch(){
        float prob= 5/100f * ( (getWeight()-10000f) /getMax_weight());
        return prob>=0.015;
    }
    @Override
    public boolean land(){
        float prob= 1/100f * ( (getWeight()-10000f) /getMax_weight());
        return prob>=0.004;
    }
}
