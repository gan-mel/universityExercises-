import java.util.Scanner;

public class Resistors {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter 3 integers");
        System.out.println("please enter r1:");
        double r1= 1.0 / scan.nextInt();
        System.out.println("please enter r2:");
        double r2= 1.0 / scan.nextInt();
        System.out.println("please enter r3:");
        double r3= 1.0 / scan.nextInt();

        double result =  1 / (r1+r2+r3) ;


        System.out.printf("The total resistence of resistors %s, %s and %s connected in parallel is: %s", r1,r2,r3,result);
    }

    }

//((1/r1) + (1/r2) + (1/r3)
