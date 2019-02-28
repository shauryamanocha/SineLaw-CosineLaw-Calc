/**
 * Math Calc
 * Solves for angles and side length using sine law and cosine law
 * Shaurya Manocha
 * Last updated Feb 28 2019
 */

import java.util.Scanner;
class mathCalc{
    public static Scanner scan = new Scanner(System.in);//scanner to input values
    public static void main(String[] args){
        runCalc();//run the main function to calculate sine or cosine law
    }

    public static void runCalc(){
        say("Welcome to Sine / Cosine Calc");//welcome message
        say("What Kind of Operation would you like?");
        say("Enter 1 for Sine Law, or 2 for Cosine Law");
        switch((int)askDouble()){//get the menu selection
            case 1:
                sineLaw();//run the appropriate function depending on the 
            break;
            case 2:
                cosineLaw();//run the appropriate function depending on the 
            break;
            default:
                say("Please Enter a valid selection");//if the menu selection is invalid try again
                runCalc();
            break;
        }
    }

    public static String askString(String prompt){
        /**
         * asks the user for a console input, and returns a string
         * prompt is printed to console
         */
        
        say(prompt);
        String result = "";
        while(result == ""){
            try{
                result = scan.next();
            }catch(Exception e){
                say("Please enter a valid response");
            }
        }
        return result;
    }

    public static void restart(){
        /**
         * asks if the user would like to start the calculation over
         */
        say("Would you like to continue? Enter Y for yes, or N for No");//ask the user if they want to restart
        switch(askString().toUpperCase()){//get the user response
            case "Y":
                say("Restarting");//restart the calculation
                runCalc();
            break;
            case "N":
                say("Thank you for shopping with, me I guess?");//end the program
                
            break;
            default:
                say("Please Enter a valid response");//ask again if the user gave an invalid response
                restart();
            break;
        }
    }
    public static String askString(){
        /**
         * returns a string value from the console printing a prompt
         */
        String result = "";
        while(result == ""){//keep checking for values until one is given
            try{
                result = scan.next();//get the result from the console
            }catch(Exception e){
                say("Please enter a valid response");//if the response is invalid somehow keep trying
            }
        }
        return result;//return the console result
    }

    public static double sin(double input){
        /**
         * converts Math.sin to work with degress
         */
        return Math.toDegrees(Math.sin(Math.toRadians(input)));
    }
    public static double asin(double input){
        /**
         * converts Math.asin to work with degress
         */
        return Math.toDegrees(Math.asin(Math.toRadians(input)));
    }
    public static double cos(double input){
        /**
         * converts Math.cos to work with degress
         */
        return Math.toDegrees(Math.cos(Math.toRadians(input)));
    }
    public static double acos(double input){
        /**
         * converts Math.acos to work with degress
         */
        return Math.toDegrees(Math.acos(Math.toRadians(input)));
    }

    public static void sineLaw(){
        say("Sine Law it is!");//welcome message
        say("Would you like to solve for an Angle (A), or a Side Length (B)?");//ask the user what they want to solve for
        double result = Double.NaN;//instantiate the result
        switch(askString().toUpperCase()){
            case "A":
                say("Solving for angle A");//indication message
                double complimentarySideLength = askDouble("Enter the complimentary side length (a)");//get all the components of the equation
                double remainingSideLength = askDouble("Enter the remaining side length (b)");
                double remainingAngle = askDouble("Enter the remaining angle (B)");
                result = asin((complimentarySideLength*sin(remainingAngle))/remainingSideLength);//perform the equation
            break;
            case "B":
                say("Solving for side a");//indication message
                double A = askDouble("Enter the complimentary angle (A)");//get all necessary components of the  equation
                double b = askDouble("Enter the remaining Side Length (b)");
                double B = askDouble("Enter the remaining Angle (B)");
                result = (b*sin(A))/sin(B);//perform the equation
            break;
            default:
                say("Please enter a valid selection");//restart if an invalid selection was given
                sineLaw();
            break;
        }
        say("Your result is: "+Double.toString(result));//print the result
        restart();//ask the user if they want to start over
    }
    public static void cosineLaw(){
        say("Cosine Law it is!");//welcome message
        say("Would you like to solve for an angle (A), or a side (S)");//ask the user what they want to solve for
        double b,c,A,a;//create variables
        double result = Double.NaN;
        switch(askString().toUpperCase()){//get the menu selection
            case "A":
                say("Solving for angle A");//indication message
                a = askDouble("Enter the side length of side a");//get all necessary components of the equation
                b = askDouble("Enter the side length of side b");
                c = askDouble("Enter the side length of side c");
                result = acos(((a*a)-(b*b)-(c*c))/-(2*a*b));//perform the equation
            break;
            case "B":
                say("Solving for side a");//indication message
                b = askDouble("Enter the side length of side b");//get all necessary components of the equation
                c = askDouble("Enter the side length of side c");
                A = askDouble("Enter the angle of point A");
                result = (b*b)+(c*c)-2*(b*c)*cos(A);//perform the equation
            break;
            default:
                say("Please enter a valid input");//if the menu selection was invalid restart
                cosineLaw();
            break;
        }
        say("Your Result is: "+Double.toString(result));//print the result
        restart();//ask the user if they want to restart
    }

    public static void say(String msg){
        //println without typing the whole thing
        System.out.println(msg);
    }
    public static double askDouble(String prompt){
        /**
         * asks the user for an input and returns a double
         */
        say(prompt);//prints the prompt
        double result = Double.NEGATIVE_INFINITY;//instantiate the variable
        while(result == Double.NEGATIVE_INFINITY){//search for a value until one is given
            try{
                result = Double.parseDouble(scan.next());//get the input and convert it from string to double
            }catch(Exception e){
                say("Only Numbers, Please");//catch if the input cannot be converted to a double
            }
        }
        return result;//return the input as a double
    }
    public static double askDouble(){
        /**
         * returns a double without staying a prompt
         */
        double result = Double.NEGATIVE_INFINITY;//instantiate the variable
        while(result == Double.NEGATIVE_INFINITY){//search for a value until one is given
            try{
                result = Double.parseDouble(scan.next());//get the input and convert it from string to double
            }catch(Exception e){
                say("Only Numbers, Please");//catch if the input cannot be converted to a double
            }
        }
        return result;//return the input as a double
    }
}