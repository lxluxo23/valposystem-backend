package com.luiscespedes.vaposystem.utils;

public class RutUtils {

    public static boolean isValidRut(String rut) {
        boolean validate = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
            char dv = rut.charAt(rut.length() - 1);
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validate = true;
            }
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Failed!");
        }
        return validate;
    }
}
