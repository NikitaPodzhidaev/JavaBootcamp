package project_01;

import java.io.*;

public class SavingMinAndMax {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            FileHandler fileHandler = new FileHandler(br);
            FileReader fileReader = new FileReader(fileHandler.getPath(), br);
            if(fileReader.makeRead()){
                MathLogic mathLogic = new MathLogic(fileReader);
                mathLogic.findMaxMin();
                FileOutput fileOutput = new FileOutput(mathLogic);
                fileOutput.run();
            }

        } catch (IOException e){
            System.err.println("whoops");
        } 
        
    }
}

class FileOutput{
    double max;
    double min;
    public FileOutput(MathLogic mathLogic){
        this.max = mathLogic.getMax();
        this.min = mathLogic.getMin();
    }

    public void run(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"))){
            bw.write(new String(new StringBuilder().append(max+" "+min)));
        } catch (IOException e) {
            System.out.println("error. " + e.getMessage());
        }
    }
}

class MathLogic{

    private Double[] arrayNumbers;
    private int count;
    private double max;
    private double min;

    public MathLogic(FileReader fileReader){
        this.arrayNumbers = fileReader.getDoubleArray();
        this.count = fileReader.getCount();
    }

    public void findMaxMin(){
        max = Double.NEGATIVE_INFINITY;
        min = Double.POSITIVE_INFINITY;
        for(int i = 0; i < count; i++){
            if(arrayNumbers[i] > max){
                max = arrayNumbers[i];
            }
            if(arrayNumbers[i] < min){
                min = arrayNumbers[i];
            }
        }
    }

    public double getMax(){
        return max;
    }
    public double getMin(){
        return min;
    }

}

class FileReader{
    private String[] array = new String[2];
    private Double[] doubleArray;
    private int count;
    
    public FileReader(String path, BufferedReader br) throws IOException{
        try{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String str;
            int i = 0;
            while((str = br.readLine()) != null){
                array[i++] = str;
            }
            br.close();
        } catch (FileNotFoundException e){
            System.err.println("Input error. File doesn't exist.");
        }
    }

    public Double[] getDoubleArray(){
        return doubleArray;
    }

    public int getCount(){
        return count;
    }

    public boolean makeRead(){
        boolean flag = true;
        if(setCount()) {
            setDoubleArray();
        } else {
            System.out.println("Input error. Size <= 0");
            flag = false;
        }
        return flag;

    }
    public boolean setCount(){
        boolean flag = false;
        try{
            this.count = Integer.parseInt(array[0]);
            if(count <= 0) flag = false;
            else flag = true;
        } catch (NumberFormatException e){
            System.err.println("Input error. Amount isn't a number");
        }
        return flag;
    }
    
    public void setDoubleArray(){
        doubleArray = new Double[count];
        String[] splitRowStrings = array[1].trim().split("\\s+");
        for(int i = 0; i < count; i++){
            try{
                doubleArray[i] = Double.parseDouble(splitRowStrings[i]);
            } catch (NumberFormatException e){
                System.err.println("Unable to read unknown char");
            } catch (ArrayIndexOutOfBoundsException e){
                System.err.println("Input error. Insufficient number of elements");
            }
        }

    }

}

class FileHandler{
    private String path;
    public FileHandler(BufferedReader br) throws IOException{
        while(true){
            br = new BufferedReader(new InputStreamReader(System.in));
            path = br.readLine();
            try {
                br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
                br.close();
                break;
            } catch (FileNotFoundException e) {
                System.err.println("Input error. File doesn't exist");
            }
        }

    }
    
    public String getPath(){
        return path;
    }

}
