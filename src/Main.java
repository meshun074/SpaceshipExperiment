import java.io.File;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Simulation simulation= new Simulation();
        ArrayList<Item> Phase1_items= simulation.loadItems(new File("src/Phase_1.txt"));
        ArrayList<Item> Phase2_items= simulation.loadItems(new File("src/Phase_2.txt"));
        ArrayList<U1Rocket> phase1_u1= simulation.loadU1(Phase1_items);
        ArrayList<U1Rocket> phase2_u1= simulation.loadU1(Phase2_items);
        ArrayList<U2Rocket> phase1_u2= simulation.loadU2(Phase1_items);
        ArrayList<U2Rocket> phase2_u2= simulation.loadU2(Phase2_items);
        System.out.printf("""
                U1 Rocket total cost:
                Phase 1 :%s
                Phase 2 :%s
                
                ------------------
                U2 Rocket total cost:
                Phase 1 :%s
                Phase 2 :%s
                """,
                simulation.runU1Simulation(phase1_u1),
                simulation.runU1Simulation(phase2_u1),
                simulation.runU2Simulation(phase1_u2),
                simulation.runU2Simulation(phase2_u2));
    }
}