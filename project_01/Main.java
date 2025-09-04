package project_01;
import project_01.MyMath;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyMath time1 = new MyMath();
        Scanner scan = new Scanner(System.in);
        int seconds = 0;

        while(true){
            if(!scan.hasNextInt()){
                System.err.println("Could not parse a number. Please, try again");
                if(!scan.hasNext()) break;
                scan.next();
            } else {
                seconds = scan.nextInt();
                if(seconds < 0) System.err.println("Incorrect time");
                else break;
            }
        }

        time1.setSeconds(seconds); // 1 method
        time1.setTime(); // 2 method
        time1.printTime(); // 3 method


    }
}
