package project_01;

public class MyMath {
    private int seconds, minutes, hours;

    public void setSeconds(int seconds){
        this.seconds = seconds;
    }

    public void setTime(){
        this.hours = this.seconds / 3600;
        this.minutes = (this.seconds % 3600) / 60;
        this.seconds = this.seconds % 60;
    }
    
    public void printTime(){
        System.out.printf("%02d:%02d:%02d\n", this.hours, this.minutes, this.seconds);
    }
    
}
