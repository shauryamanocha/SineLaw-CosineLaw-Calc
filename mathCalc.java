import java.util.Scanner;
class mathCalc{
    public static Scanner scan = new Scanner(System.in);
    static boolean continuing = true;
    public static void main(String[] args){
        say("Welcome to Sine / Cosine Calc");
        say("What Kind of Operation would you like?");
        say("Enter 1 for Sine Law, or 2 for Cosine Law");
        while(continuing){
            switch((int)askDouble()){
                case 1:
                    sineLaw();
                break;
                case 2:
                    cosineLaw();
                break;
                default:
                    say("Please Enter a valid selection");
                break;
            }
        }
    }

    public static String askString(String prompt){
        say(prompt);
        String result = "";
        while(result == ""){
            try{
                result = scan.next();
            }catch(Exception e){
                say("Only Numbers, Please");
            }
        }
        return result;
    }
    public static String askString(){
        // say(prompt);
        String result = "";
        while(result == ""){
            try{
                result = scan.next();
            }catch(Exception e){
                say("Only Numbers, Please");
            }
        }
        return result;
    }

    public static double sin(double input){
        return Math.toDegrees(Math.sin(Math.toRadians(input)));
    }
    public static double asin(double input){
        return Math.toDegrees(Math.sin(Math.toRadians(input)));
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
    }
    public static void cosineLaw(){
        
        continuing = false;
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