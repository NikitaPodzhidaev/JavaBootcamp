package project_01;
import java.io.*;

public class FirstLastNumber {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                int amount = Integer.parseInt(new String(br.readLine()).trim());
                if(amount <= 0) throw new IllegalArgumentException();
                TaskArray taskArray = new TaskArray(amount, br);
                taskArray.run();
                break;
            } catch (NumberFormatException e) {
                System.err.println("Could not parse a number. Please, try again.");
            } catch (IOException e) {
                System.err.println("Some I/O Exception " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println(("Input error. Size <= 0"));
            }
        }
    }

    static class Number{
        static int findFirst(int number){
            number = Math.abs(number);
            while( number >= 10 ) number /= 10;
            return number;
        }

        static int findLast(int number){
            return Math.abs(number) % 10;
        }

        static boolean firstEqualsLast(int number){
            return findFirst(number) == findLast(number);
        }


    }

    private static class TaskArray {

        private int amount;
        private int[] someArray;
        private int[] arrayLastFirstEquals;
        private BufferedReader br;

        public TaskArray(int amount, BufferedReader br){
            this.amount = amount;
            someArray = new int[amount];
            this.br = br;
        }

        public void run() throws IOException{
            readArray();
            dataProcessor();
            printArray();

        }

        private void readArray() throws IOException{
            int current = 0;
            while(current < amount){
                String line = br.readLine();
                if(line == null) throw new EOFException("Not enought numbers");
                String[] parsedParts = line.trim().split("\\s+");
                for(String part : parsedParts) {
                    if(part.isEmpty()) continue;
                    someArray[current++] = Integer.parseInt(part);
                    if (current == amount) break;
                }
            }
        }
        
        private void dataProcessor(){
            int count = 0;
            for(int x : someArray){
                if(Number.firstEqualsLast(x)) count++;
            }
            arrayLastFirstEquals = new int[count];
            int j = 0;
            for(int x : someArray){
                if(Number.firstEqualsLast(x)) arrayLastFirstEquals[j++] = x;
            }
        }

        private void printArray(){
            if(arrayLastFirstEquals.length > 0) {
                for(int x : arrayLastFirstEquals) System.out.printf("%d ", x);
            } else {
                System.out.println("There are no such elements");
            }
        }

    }
    
}
