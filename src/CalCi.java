import java.util.Scanner;
import java.util.LinkedList;

public class CalCi {

    public static void LogicalState(String UserEquation) {
        double Solution = 0.0;



        System.out.println(UserEquation + " == "+Solution);
    }
    public static void main(String[] args) {
        // Variable's Land
        Scanner Scan = new Scanner(System.in);
        boolean CalCiActive = true;
        String[] LastOperations = new String[9];



        System.out.println("CalCI For The Next Generation you!");

        while (CalCiActive) {
            System.out.print("> ");
            String UserEquation = Scan.nextLine();


            // LOGICAL STATEMENTS
            LogicalState(UserEquation);



            // EXIT STATEMENT CODE:0
            if(UserEquation.equals("/exit")) {
                System.out.println("BYE BYE!");
                CalCiActive = false;
            }
        }

    }
}
