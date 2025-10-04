import java.util.Random;
import java.util.Scanner;
public class PasswordGenerator {
    public static void main(String[] args){
        String[] alphabet = {"a", "b", "c", "d", "e", // small chars
                        "f", "g", "h", "i", "j",
                        "k", "l", "m", "n", "o",
                        "p", "q", "r", "s", "t",
                        "u", "v", "w", "x", "y", "z", // big chars
                        "A", "B", "C", "D", "E",
                        "F", "G", "H", "I", "J",
                        "K", "L", "M", "N", "O",
                        "P", "Q", "R", "S", "T",
                        "U", "V", "W", "X", "Y", "Z",
                        "1", "2", "3", "4", "5", // numbers
                        "6", "7", "8", "9", "0"}; 
        byte symbolCount = 0;
        byte randomNumber = 0;
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
        for(byte i = 1; i <= symbolCount; i++){
            //System.out.println(alphabet.length); // test
            randomNumber = (byte)random.nextInt((alphabet.length));
            generatedPassword += alphabet[randomNumber];
            
        }
        System.out.println(generatedPassword);
        scanner.close();
    }
}
