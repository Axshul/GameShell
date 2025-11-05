import javax.naming.OperationNotSupportedException;
import javax.swing.text.View;
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


            //FOR ADDITION OF LINE & CODEBASE
            if (Line != "" && !Line.equals(":r") && !Line.equals(":wq") && !Line.equals(":vw") && !Line.equals(":ed")) {
                CodeList.add(Line);
                OnLine += 1;
            }

            if (Line.equals(":wq")) { //FOR QUIT
                    Editor = false;
                    System.out.println("WQ: Crafting Next");
            }

            if(Line.equals(":r")){ //FOR RUNNING CODE BASE
                    System.out.println();
                    System.out.println("Running Current Code Base...");
                    System.out.println("Code View: "+Header);
                    ViewCode(CodeList);
                    System.out.println();
                    System.out.println("Next Action: ");
            }

            if(Line.equals(":vw")){ //VIEW SNIPPET
                System.out.println("Your Current Code Base:");
                ViewCode(CodeList);
            }

            if(Line.equals(":ed")){ //EDIT PREV CODE
                System.out.println("EDITING PREV LINE...");
                System.out.println("Enter Line Number To Hop: ");
                int LineNumber = Scan.nextInt();
                System.out.println("Current Line["+LineNumber+"]"+" State Is: "+CodeList.get(LineNumber));
                System.out.println("Now Edit Below, Press Enter To Finalise:");
                String NewEdit = Scan.nextLine(); // THIS CAUSE TROUBLE WITH " "
                System.out.println("SAVING..");
                CodeList.set(LineNumber, NewEdit);
                System.out.println("Updated Code Base: ");
                ViewCode(CodeList);

            }

        }



    }
    //VIEW SNIPPET
    public static void ViewCode(ArrayList CodeList) {
        for(int view = 0; view < CodeList.size(); view++){
            System.out.println("-----["+view+"]-----(> "+CodeList.get(view));
        }
    }
}