package org.example;
import java.util.Scanner;
public class ValidadorRutGPT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rut;
        do {
            System.out.print("Ingrese el RUT (sin puntos ni guión): ");
            rut = scanner.next();
        } while (!isValidRut(rut));
        int verifDigit = calculateVerificationDigit(rut);
        System.out.println("El dígito verificador del RUT es: " + verifDigit);
    }

    public static boolean isValidRut(String rut) {
        return rut.matches("\\d{7,8}");
    }

    public static int calculateVerificationDigit(String rut) {
        int[] multipliers = {2, 3, 4, 5, 6, 7, 2, 3};
        int sum = 0;
        int j = 0;
        for (int i = rut.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(rut.substring(i, i+1));
            sum += digit * multipliers[j++];
            if (j == multipliers.length) {
                j = 0;
            }
        }
        int division = sum / 11;
        int remainder = sum % 11;
        int verificationDigit;
        if (remainder == 0) {
            verificationDigit = 0;
        } else if (remainder == 1) {
            verificationDigit = 'k';
        } else {
            verificationDigit = 11 - remainder;
        }
        return verificationDigit;
    }

}
