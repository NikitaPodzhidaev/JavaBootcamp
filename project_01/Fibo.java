package project_01;
import java.io.*;
// import java.util.*;
public class Fibo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                int number = Integer.parseInt(br.readLine());
                Fibokek fibokek = new Fibokek(number);
                fibokek.fiboFind();
                fibokek.displayInfo();
                break;
            }
            catch (NumberFormatException nfe) {
                System.err.println("Could not parse a number. Please, try again");
            }  
            catch (StackOverflowError soe) {
                System.err.println("Could not parse a number. Please, try again");
            }
        }
        
    }


}

class Fibokek {
    
    private int number;
    private int amount;

    public Fibokek(int number){
        this.number = number;
    }

    public int fiboCount(int number){
        if(number == 1 || number == 2) return 1;
        return fiboCount(number-1) + fiboCount(number-2);

    }

    public void fiboFind(){
        this.amount = fiboCount(this.number);
    }

    public void displayInfo(){
        System.out.println("Number is: " + this.amount);
    }


}
