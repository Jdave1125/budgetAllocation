//BUDGET ALLOCATION
// Enter your budget, enter proportion of each expense item
//Ignore further items if proportion exceeds 100%
// use ArrayList to store expense proportions
// find amount for each item

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            //allow user input
            System.out.println("What are you willing to spend?");
            Scanner scan = new Scanner(System.in); // allow user input
            double total = scan.nextDouble(); //store user input in double var
            double sum = 0; //keeping track of running total (needs to be under 100)
            int i = 0; //ref to expense item index

            ArrayList<Double> proportion = new ArrayList<Double>(); //create ArrayList
            System.out.println("Enter your proportion of various expenses.");
            System.out.println("The system stops if total proportions exceed 100%");

            while(sum <= 100) {
                System.out.println("Your proportion of expense " + (i+1) + ":");
                double value = scan.nextDouble();
                proportion.add(value);
                sum += proportion.get(i);
                i++;
            }
            scan.close();
            //nice

            if(sum>100){
                double cumulativeSum = 0.0;
                for (int j=0 ; j<proportion.size()-1;j++){
                    cumulativeSum += proportion.get(j);
                }
                proportion.set(proportion.size()-1, 100.0 - cumulativeSum );
            }

            for(double value : proportion){
                double expense = value*total / 100.0;
                System.out.println("Your " + value + "% equals $" + expense);
            }
        }
    }
