package project_01;
import java.io.*;

public class SelectSortArray {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            InputHandler inputHandler = new InputHandler();
            double[] array = inputHandler.getInputArray(br);
            ArraySorter.selectSort(array);
            ArrayPrinter.printArray(array);
        } catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }

}

final class ArrayPrinter{
    public static void printArray(double[] array){
        for(double x : array) System.out.print(x + " ");
    }
}
class ArraySorter{
    public static void selectSort(double[] array){
        for(int i = 0; i < array.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j < array.length; j++){
                if(array[minIndex] > array[j]) minIndex = j; 
            }
            double box = array[i];
            array[i] = array[minIndex];
            array[minIndex] = box;
        }
    }
}

class InputHandler{
    private static double[] array;
    private static int capacity;
    
    public double[] getInputArray(BufferedReader br) throws IOException{
        setCapacity(br);
        setArray(br);
        return array;
    }

    public static void setCapacity(BufferedReader br) throws IOException{
        while(true){
            try{
                capacity = Integer.parseInt(br.readLine());
                if(capacity > 0) {
                    array = new double[capacity];
                    break;
                }
                else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException exception){
                System.err.println("Could not parse a number. Please, try again");
            }
        }
    }

    public static void setArray(BufferedReader br) throws IOException {
        String[] inputStrings = br.readLine().trim().split(" ");
        while(true){    
            if(inputStrings.length != capacity) {
                System.err.println("Amount of numbers doesn't equal capacity");
                inputStrings = br.readLine().trim().split(" ");
            } else {
                for(int i = 0; i < capacity; i++){
                    array[i] = Double.parseDouble(inputStrings[i]);
                }
                break;
            }
        }
    }

}