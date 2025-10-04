import java.util.Random;
import java.util.Scanner;
public class PasswordGenerator {
    public static void main(String[] args){
        String[] bigLetters = {"A", "B", "C", "D", "E",
                                    "F", "G", "H", "I", "J",
                                    "K", "L", "M", "N", "O",
                                    "P", "Q", "R", "S", "T",
                                    "U", "V", "W", "X", "Y", "Z"}; 
        String[] smallLetters = {"a", "b", "c", "d", "e",
                                    "f", "g", "h", "i", "j",
                                    "k", "l", "m", "n", "o",
                                    "p", "q", "r", "s", "t",
                                    "u", "v", "w", "x", "y", "z"};
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] specialSymbols = {"!", "@", "#", "$", "%",
                                    "&", "*", "-", "_", "!",
                                    "?", "+", "="};
        byte symbolCount = 0;
        byte randomNumber = 0;
        byte choice = 0;
        String[] customArray = {};
        String generatedPassword = "";
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        try{
            System.out.print("How many characters will the be in the password? ");
            symbolCount = scanner.nextByte();
            if(symbolCount <= 0){
                System.out.println("Error: You can't generate a password that is less than 0 characters.");
                System.exit(0);
            }
        }
        catch(Exception ex){
            // Capturing the moment, if user enters number which is greater than 127 due to the byte type of variable
            System.out.println("Error: You can't generate a password that is more than 127 characters.");
            // Lol, why you need a password which is greater than 127 characters 💀 127 is enough
        }

        try{
            System.out.println("What letter case option do you want in your password?");
            System.out.println("1. Big ");
            System.out.println("2. Small ");
            System.out.println("3. Both");
            System.out.print("Your choice (Type it like 1 or 3): ");
            choice = scanner.nextByte();
            if(choice == 1){
                customArray = concatArray(customArray, bigLetters);
            }
            else if(choice == 2){
                customArray = concatArray(customArray, smallLetters);
            }
            else if(choice == 3){
                customArray = concatArray(customArray, bigLetters);
                customArray = concatArray(customArray, smallLetters);
                
            }
            else{
                System.out.println("Error: You chose the wrong option.");
            }
        }
        catch(Exception ex){
            System.out.println("Error: You wrote non-existent options.");
        }

        try{
            System.out.println("Do you want symbols/numbers in your password?");
            System.out.println("1. Special symbols ");
            System.out.println("2. Numbers ");
            System.out.println("3. Both");
            System.out.print("Your choice (Type it like 1 or 3): ");
            choice = scanner.nextByte();
            if(choice == 1){
                customArray = concatArray(customArray, specialSymbols);
            }
            else if(choice == 2){
                customArray = concatArray(customArray, numbers);
            }
            else if(choice == 3){
                customArray = concatArray(customArray, specialSymbols);
                customArray = concatArray(customArray, numbers);
                
            }
            else{
                System.out.println("Error: You chose the wrong option.");
            }
        }
        catch(Exception ex){
            System.out.println("Error: You wrote non-existent options.");
        }
        
        // Lets finally generate our amazing password :3
        for(byte i = 1; i <= symbolCount; i++){
            //System.out.println(customArray.length); // test
            randomNumber = (byte)random.nextInt(customArray.length);
            generatedPassword += customArray[randomNumber];
            
        }
        System.out.println("Your password is: " + generatedPassword);
        scanner.close();
    }

    public static String[] concatArray(String[] mainArray, String[] additionalArray){
        String[] result = new String[mainArray.length + additionalArray.length];
        for(int i = 0; i < mainArray.length; i++){
            result[i] = mainArray[i];
        }
        for(int i = 0; i < additionalArray.length; i++){
            result[mainArray.length + i] = additionalArray[i];
        }

        return result;
    }
}
