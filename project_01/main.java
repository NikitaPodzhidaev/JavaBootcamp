    package project_01;
    import java.util.Scanner;
    import java.util.Locale;
    public class main {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            while(true){
                try {
                double x1 = 0.0, y1 = 0.0, x2 = 0.0, y2 = 0.0, x3 = 0.0, y3 = 0.0;
                scan.useLocale(Locale.US);
                x1 = scan.nextDouble();
                y1 = scan.nextDouble();
                x2 = scan.nextDouble();
                y2 = scan.nextDouble();
                x3 = scan.nextDouble();
                y3 = scan.nextDouble();
                
                double first = vector_length(x1, y1, x2, y2);
                double second = vector_length(x2, y2, x3, y3);
                double third = vector_length(x1, y1, x3, y3);

                if(isTriangle(first, second, third)){
                    System.out.printf("Perimeter: %.3f\n", first+second+third);
                } else {
                    System.out.println("It's not a triangle");
                }
                break;

                } catch (Exception e) {
                    System.err.println("Could not parse a number. Please, try again");
                    if(scan.hasNext()){
                        scan.next();
                    }
                }

            }

        }

        public static boolean isTriangle(double first, double second, double third){
            boolean result = ((first + second) > third) && ((first + third) > second) && ((second + third) > first);
            return result;
        }

        public static double vector_length(double x1, double y1, double x2, double y2){
            double pre_result = Math.pow((x2-x1), 2.0) + Math.pow((y2-y1), 2.0);
            double result = Math.sqrt(pre_result);
            return result;
        }
    }
