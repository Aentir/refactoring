package com.kreitek.refactor.mal.identifications;

import com.kreitek.refactor.mal.ID;

public class DNI{

    private ID enumTipo;
    private String numDNI;

    public DNI(ID tipo, String numDNI) {
        this.enumTipo = tipo;
        this.numDNI = numDNI;
    }

    private char getDNICharacter(){
        return this.numDNI.charAt(8);
    }

    private String getDNINumbers(){
        return this.numDNI.trim().replaceAll(" ", "").substring(0, 8);
    }

    private int restDNIcalc(){
        return Integer.parseInt(getDNINumbers()) % 23;
    }

    private boolean correctDNIletter(){
        final String dniChars="TRWAGMYFPDXBNJZSQVHLCKE";
        return dniChars.charAt(restDNIcalc()) == getDNICharacter();
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean correctDNI(){
        return this.numDNI.length() == 9 && isNumeric(getDNINumbers()) && correctDNIletter();
    }
}
