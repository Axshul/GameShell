import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try { //To Support Sleeping Threads... millis:3000(3Sec)
            System.out.println("Sleeping Thread T1");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}