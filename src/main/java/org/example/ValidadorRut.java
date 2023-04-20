package org.example;
import java.util.Scanner;
public class ValidadorRut {
    public static void main(String[] args) {
        rut();
    }
    public static void rut(){
        String rut =ingresarRut();
        String rutSinPuntoSinGuion = rutSinPuntoSinGuion(rut);
        String rutInvertido = invertirCadena(rutSinPuntoSinGuion);
        String rutSinDigitoVerificador = rutSinDigitoVerificador(rutInvertido);
        int[] cadena1 = convertirInt(rutSinDigitoVerificador);
        int[] cadena2 = crearCadena2(cadena1);
        String digitoVerificador = digitoVerificador(cadena1, cadena2);
        System.out.print("El digito verificador es: ");
        System.out.println(digitoVerificador);

    }
    public static String ingresarRut(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su rut completo:");
        String rut = sc.nextLine();
        return rut;
    }
    public static String rutSinPuntoSinGuion(String rut){
        String rutSinPuntoSinGuion = rut.replace(".","");
        return rutSinPuntoSinGuion.replace("-", "");
    }
    public static String invertirCadena(String cadena1) {
        String cadena2 = "";
        for (int i = cadena1.length() - 1; i >= 0; i--) {
            char letra = cadena1.charAt(i);
            cadena2 = cadena2 + letra;
        }
        return cadena2;
    }
    public static String rutSinDigitoVerificador (String rut){
        return rut.substring(1);
    }
    public static int [] convertirInt (String cadena){
        int[] rut = new int [cadena.length()];
        String[] parts = cadena.split("");
        try {
            for ( int i = 0; i < cadena.length() ; i++) {
                rut[i] = Integer.parseInt(parts[i]);
            }
        } catch (Exception e) {
            System.out.println("'ERROR' ingrese un rut valido");
            rut();
        }

      //  int[] rut = new int [cadena.length()];
      //  String[] parts = cadena.split("");
      //  for ( int i = 0; i < cadena.length() ; i++) {
       //     rut[i] = Integer.parseInt(parts[i]);
      //  }
        return rut;
    }
    public static int[] crearCadena2(int[] cadena1){
        int contador = 2;
        int[] cadena2 = new int[cadena1.length];
        for (int i = 0; i < cadena2.length ; i++) {
            cadena2[i] = contador;
            if (contador == 7){
                contador = 2;
            }
            else contador++;
        }
        return cadena2;
    }
    public static String digitoVerificador(int[] cadena1, int[]cadena2){
        int multiplicador = 0;
        for (int i = 0; i < cadena1.length; i++) {
            multiplicador = (multiplicador + cadena1[i]*cadena2[i]);
        }
        int dividor = multiplicador/11;
        int multiplicador2 = dividor*11;
        int resta = multiplicador-multiplicador2;
        int valorAbsoluto = resta;
        if (valorAbsoluto<0){
            valorAbsoluto = -valorAbsoluto;
        }
        int digito = 11-valorAbsoluto;
        String digitoVerificador = "";
        if (digito<10){
            digitoVerificador = digito+"";
        } else if (digito == 10) {
            digitoVerificador = "k";
        }else digitoVerificador = "0";
        return digitoVerificador;
    }
}
