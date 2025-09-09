package project_01;
import java.io.*;

public class AvgNegative {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try{
                int amount = Integer.parseInt(br.readLine());
                if(amount <= 0) {
                    System.out.println("Input error. Size <= 0");
                } else {
                    NegativeArray negativeArray = new NegativeArray(amount);
                    negativeArray.allMethodsStart();
                    break;
                }
                
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
            }

            
        }
    }

    public static class NegativeArray{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private int amount;
        private int countNegative = 0;
        private int averageNegative;
        private int negativeArray[];

        public NegativeArray(int amount){
            this.amount = amount;
        }

        public void allMethodsStart() throws IOException{
            readArray();
            negativeCheck();
        }
        
        public void readArray() throws IOException{
            
            String s = br.readLine();
            String[] p = s.trim().split("\\s+");
            int[] intArray = new int[amount];
            for(int i = 0; i < amount; i++){
                intArray[i] = Integer.parseInt(p[i]);
                if(intArray[i] < 0){
                    countNegative++;
                }
            }
            negativeArray = new int[countNegative];
            int index = 0;
            for(int x : intArray){
                if (x < 0) negativeArray[index++] = x;
            }
        }

        public void negativeCheck(){
            if(this.countNegative > 0){
                countNegativeAverage();
                printInfo();
            } else {
                System.out.println("There are no negative elements.");
            }
        }
        
        public void countNegativeAverage(){
            int sum = 0;
            for(int i : negativeArray){
                sum += i;
            }
            averageNegative = sum / negativeArray.length;
        }

        public void printInfo(){
            System.out.println(averageNegative);
        }
        
        

    }

}
