import java.util.Scanner;
class mathCalc{
    public static Scanner scan = new Scanner(System.in);
    static boolean continuing = true;
    public static void main(String[] args){
        runCalc();
    }

    public static void runCalc(){
        say("Welcome to Sine / Cosine Calc");
        say("What Kind of Operation would you like?");
        say("Enter 1 for Sine Law, or 2 for Cosine Law");
        switch((int)askDouble()){
            case 1:
                sineLaw();
                // restart();
            break;
            case 2:
                cosineLaw();
                // restart();
            break;
            default:
                say("Please Enter a valid selection");
            break;
        }
    }

    public static String askString(String prompt){
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
        say("Would you like to continue? Enter Y for yes, or N for No");
        switch(askString().toUpperCase()){
            case "Y":
                say("Restarting");
                // continuing = true;
                runCalc();
            break;
            case "N":
                say("Thank you for shopping with, me I guess?");
                // continuing = false;
                
            break;
            default:
                say("Please Enter a valid response");
                restart();
            break;
        }
    }
    public static String askString(){
        // say(prompt);
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

    public static double sin(double input){
        return Math.toDegrees(Math.sin(Math.toRadians(input)));
    }
    public static double asin(double input){
        return Math.toDegrees(Math.asin(Math.toRadians(input)));
    }
    public static double cos(double input){
        return Math.toDegrees(Math.cos(Math.toRadians(input)));
    }
    public static double acos(double input){
        return Math.toDegrees(Math.acos(Math.toRadians(input)));
    }

    public static void sineLaw(){
        say("Sine Law it is!");
        say("Would you like to solve for an Angle (A), or a Side Length (B)?");
        double result = Double.NaN;
        switch(askString().toUpperCase()){
            case "A":
                say("Solving for angle A");
                double complimentarySideLength = askDouble("Enter the complimentary side length (a)");
                double remainingSideLength = askDouble("Enter the remaining side length (b)");
                double remainingAngle = askDouble("Enter the remaining angle (B)");
                result = asin((complimentarySideLength*sin(remainingAngle))/remainingSideLength);
            break;
            case "B":
                say("Solving for side a");
                double A = askDouble("Enter the complimentary angle (A)");
                double b = askDouble("Enter the remaining Side Length (b)");
                double B = askDouble("Enter the remaining Angle (B)");
                result = (b*sin(A))/sin(B);
            break;
            default:
                say("Please enter a valid selection");
                sineLaw();
            break;
        }
        say("Your result is: "+Double.toString(result));
        continuing = false;
        restart();
    }
    public static void cosineLaw(){
        say("Cosine Law it is!");
        say("Would you like to solve for an angle (A), or a side (S)");
        double b,c,A,a;
        double result = Double.NaN;
        switch(askString().toUpperCase()){
            case "A":
                say("Solving for angle A");
                a = askDouble("Enter the side length of side a");
                b = askDouble("Enter the side length of side b");
                c = askDouble("Enter the side length of side c");
                result = acos(((a*a)-(b*b)-(c*c))/-(2*a*b));
            break;
            case "B":
                say("Solving for side a");
                b = askDouble("Enter the side length of side b");
                c = askDouble("Enter the side length of side c");
                A = askDouble("Enter the angle of point A");
                result = (b*b)+(c*c)-2*(b*c)*cos(A);
            break;
            default:
                say("Please enter a valid input");
                cosineLaw();
            break;
        }
        say("Your Result is: "+Double.toString(result));
        continuing = false; 
        restart();
    }

    public static void say(String msg){
        System.out.println(msg);
    }
    public static double askDouble(String prompt){
        say(prompt);
        double result = Double.NEGATIVE_INFINITY;
        while(result == Double.NEGATIVE_INFINITY){
            try{
                result = Double.parseDouble(scan.next());
            }catch(Exception e){
                say("Only Numbers, Please");
            }
        }
        return result;
    }
    public static double askDouble(){
        double result = Double.NEGATIVE_INFINITY;
        while(result == Double.NEGATIVE_INFINITY){
            try{
                result = Double.parseDouble(scan.next());
            }catch(Exception e){
                say("Only Numbers, Please");
            }
        }
        return result;
    }
}