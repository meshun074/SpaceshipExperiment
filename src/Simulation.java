import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems(File file)
    {
        ArrayList<Item> items=new ArrayList<>();
        String text;
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext())
            {
                text=sc.nextLine();
                Item item= new Item(text.substring(0,text.indexOf("=")),Integer.parseInt(text.substring(text.indexOf("=")+1)));
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return items;
    }
    public  ArrayList<U1Rocket> loadU1(ArrayList<Item> items)
    {
        ArrayList<U1Rocket> U1Rockets = new ArrayList<>();
        Iterator<Item> u1 =items.iterator();
        U1Rocket u1Rocket= new U1Rocket();
        while (u1.hasNext())
        {
            Item item=u1.next();
            if(u1Rocket.canCarry(item))
                u1Rocket.carry(item);
            else
            {
                U1Rockets.add(u1Rocket);
                u1Rocket=new U1Rocket();
                if (u1Rocket.canCarry(item))
                    u1Rocket.carry(item);
            }
        }
        U1Rockets.add(u1Rocket);
        return U1Rockets;
    }
    public ArrayList<U2Rocket> loadU2(ArrayList<Item> items)
    {
        ArrayList<U2Rocket> U2Rockets = new ArrayList<>();
        Iterator<Item> u2 =items.iterator();
        U2Rocket u2Rocket= new U2Rocket();
        while (u2.hasNext())
        {
            Item item=u2.next();
            if(u2Rocket.canCarry(item))
                u2Rocket.carry(item);
            else
            {
                U2Rockets.add(u2Rocket);
                u2Rocket=new U2Rocket();
                if (u2Rocket.canCarry(item))
                    u2Rocket.carry(item);
            }
        }
        U2Rockets.add(u2Rocket);
        return U2Rockets;
    }
    public int runU1Simulation(ArrayList<U1Rocket> u1rockets)
    {
        int total_budget=0;
        for (U1Rocket rocket : u1rockets) {
            total_budget += rocket.getCost();
            if (rocket.launch())
                if (rocket.land())
                    break;
        }
        System.out.println("Phase");
        return total_budget;
    }

    public int runU2Simulation(ArrayList<U2Rocket> u2rockets)
    {
        int total_budget=0;
        for (U2Rocket rocket : u2rockets) {
            total_budget += rocket.getCost();
            if (rocket.launch())
                if (rocket.land())
                    break;
        }
        return total_budget;
    }
}
