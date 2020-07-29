
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System.*;
import java.lang.invoke.StringConcatException;
import java.util.Scanner;

import java.math.RoundingMode;
import java.text.DecimalFormat;

//  Driver
public class Main {

    private static DecimalFormat df2 = new DecimalFormat("#.00");

    public static void main (String[] args) {

        boolean cont = true;
        boolean error = true;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        while(cont) {

            Person person = new Person();

            String name = null;

            //  Check for string
            while(name == null) {
                System.out.println("Please enter your name: ");

                try {
                     name = scanner.nextLine();
                } catch (Exception exception) {
                    System.err.println("Not a string");
                }
                //  Set the persons name to the name given
                person.setName(name);
            }
            
            
            System.out.println("Hello " + person.getName());

            
            error = true;

            //  Check for double
            while(error) {

                System.out.println("Please enter your monthly income: ");

                double monthlyIncome = 0;

                try {
                    monthlyIncome = Double.parseDouble(scanner.nextLine());
                    error = false;
                } catch (NumberFormatException exception) {
                    System.err.println("Not a double");

                }

                person.setMonthlyIncome(monthlyIncome);
            }
            System.out.println("\nFollowing the 50/30/20 rule which is:" +
                    "\n50% of monthly income to needs" +
                    "\n30% to wants" +
                    "\n20% to savings/debt" +
                    "\n" +
                    "\nThis is how your current budget looks" +
                    "\n" +
                    "\n" +
                    "Total monthly income: " + df2.format(person.getMonthlyIncome()) +
                    "\nNeeds: " + df2.format(person.getMonthlyIncome() * .50) +
                    "\nWants: " + df2.format(person.getMonthlyIncome() * .30) +
                    "\nSavings/Debt: " + df2.format(person.getMonthlyIncome() * .20));


            System.out.println("Would you like to put calculate another budget?[Y/N]");
            if (scanner.next().charAt(0) == 'N' || scanner.next().charAt(0) == 'n'){
                cont = false;

            }


            //  System.out.println(person.getName());
            //  System.out.println(person.getMonthlyIncome());
        }
    }

}
