package project_01;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Uppor {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayHandler arrayHandler = new ArrayHandler(br);
        if(arrayHandler.setArray()){
            ArrayLogic.run(arrayHandler.getArray());
            Printer.printInformation();
        }
    }
}


class ArrayHandler{
    private List<Integer> al = new ArrayList<Integer>();
    private BufferedReader br;
    public ArrayHandler(BufferedReader br){
        this.br = br;
    }

    public boolean setArray(){
        boolean isOkay = true;
        try{
            String[] takenInts = br.readLine().trim().split("\\s+");
            for(String x : takenInts) al.add(Integer.parseInt(x));
            if(al.size() == 0) throw new IllegalArgumentException();
        } catch (IOException e) {
            System.err.println("There must be an error. " + e.getMessage());
            isOkay = false;
        } catch (NumberFormatException e) {
            System.err.println("The sequence is ordered in ascending order.");
            isOkay = false;
        } catch (IllegalArgumentException e) {
            System.err.println("Input error.");
            isOkay = false;
        }
        return isOkay;
    }

    public List<Integer> getArray(){
        return al;
    }

}

final class Printer{

    public static void printInformation(){
        if(ArrayLogic.getIS_SORTED()){
            System.out.println("The array is sorted.");
        } else {
            System.out.println("The sequence is not ordered from the ordinal number of the number " + ArrayLogic.getFIRST_UNSORTED());
        }
    }
    
}

class ArrayLogic{
    private static boolean IS_SORTED = true;
    private static int FIRST_UNSORTED;

    public static boolean getIS_SORTED(){
        return IS_SORTED;
    }

    public static int getFIRST_UNSORTED(){
        return FIRST_UNSORTED;
    }

    public static void run(List<Integer> al){

        if(checkFirstLast(al)){
            isSorted(al);
        } else {
            IS_SORTED = false;
            FIRST_UNSORTED = 0;
        }

    }

    private static void isSorted(List<Integer> al){
        for(int i = 0; i < al.size()-1; i++){
            if(al.get(i) > al.get(i+1)){
                IS_SORTED = false;
                FIRST_UNSORTED = i+1;
                break;
            }
        }
    }

    private static boolean checkFirstLast(List<Integer> al){
        if(al.get(0) > al.get(al.size()-1)) return false; 
        else return true;
    }
}
