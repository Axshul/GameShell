import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scan = new Scanner(System.in);

        int OnLine = 0;
        String ERR_STATE = "~"; // STATES: ERR_STATE[*] RISK[#] Potential_Err[@]
        String Header = "---["+ERR_STATE+ERR_STATE+ERR_STATE+ERR_STATE+"] ";
        ArrayList<String> CodeList = new ArrayList<>();
        boolean Editor = true; //To Keep The Editor Live UNTIL :wq

        System.out.println("Welcome on TUI #1 JAVA Interpreter");

        while(Editor){
                System.out.print(Header + OnLine + " | ");
                String Line = Scan.nextLine();

                if (Line.equals(":wq")) { //FOR QUIT
                    Editor = false;
                    System.out.println("WQ: Crafting Next");
                }
                if(Line.equals(":r")){ //FOR RUNNING CODE BASE
                    System.out.println();
                    System.out.println("Running Current Code Base...");
                    System.out.println("Code View: "+Header);
                    for(int view = 0; view < CodeList.size(); view++){
                        System.out.println("----------(> "+CodeList.get(view));
                    }
                    System.out.println();
                    System.out.println("Next Action: ");
                }

                //FOR ADDITION OF LINE & CODEBASE
                     if (Line != null) {
                         CodeList.add(Line);
                         OnLine += 1;
                     }

        }



    }
}