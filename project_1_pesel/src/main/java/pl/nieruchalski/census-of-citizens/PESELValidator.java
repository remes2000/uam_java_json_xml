package pl.nieruchalski;

import java.time.Period;

public class PESELValidator {
    public static boolean isValid(String peselNumber) {
        if(!peselNumber.matches("^[0-9]{11}$")) {
            return false;
        }
        Integer[] pesel = PESELValidator.convertPeselStringToPesel(peselNumber);
        Integer[] importances = new Integer[]{1, 3, 7, 9, 1, 3, 7, 9, 1, 3, 1};
        Integer controlDigit = pesel[10];
        Integer sumOfProducts = 0;
        for(int i=0; i<10; i++) {
            sumOfProducts += pesel[i] * importances[i];
        }
        Integer m = sumOfProducts % 10;
        if(m == 0) {
            return controlDigit.equals(0);
        }
        return controlDigit.equals(10-m);
    }

    private static Integer[] convertPeselStringToPesel(String peselNumber) {
        Integer[] result = new Integer[11];
        for(int i=0; i<11; i++) {
            result[i] = Integer.valueOf(peselNumber.charAt(i)) - 48;
        }
        return result;
    }
}
