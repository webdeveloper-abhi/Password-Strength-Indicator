import java.util.Scanner;

public class PasswordStrengthChecker {
     
    static boolean hasUppercase = false;
    static boolean hasLowercase = false;
    static boolean hasNumber = false;
    static boolean hasSpecial = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Your Password: ");
        String password = scanner.nextLine();

        int length = password.length();
        analizepassword(password, length);
        checkStrength(length);
   
  
    }

    static void analizepassword(String password,int length){
        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasNumber = true;
            } else if ("#@%*!".indexOf(ch) != -1) {
                hasSpecial = true;
            }
        }

    }

    static void checkStrength(int length){
        
        if (hasUppercase && hasLowercase && hasNumber && hasSpecial && length >= 8) {
            System.out.println("Your Password is Strong");
        } else if ((hasUppercase && hasLowercase && (hasNumber || hasSpecial)) && length >=6 && length<8) {
            System.out.println("Your Password is Medium");
        } else if ((hasUppercase || hasLowercase) && length < 5) {
            System.out.println("Your Password is Weak");
        } else {
            System.out.println("Your Password is very weak");
        }
    }
}
