package com.kreitek.refactor.mal.identifications;

import com.kreitek.refactor.mal.ID;

public class NIE {
    private ID enumTipo;
    private String numDNI;

    private boolean esValido = false;

    public NIE(ID tipo, String numDNI) {
        this.enumTipo = tipo;
        this.numDNI = numDNI;
    }

    private boolean getXletter(){
        return numDNI.substring(0,1).toUpperCase().equals("X");
    }

    private boolean getYletter(){
        return numDNI.substring(0,1).toUpperCase().equals("Y");
    }

    private boolean getZletter(){
        return numDNI.substring(0,1).toUpperCase().equals("Z");
    }

    private boolean checkIsLetter(){
        return Character.isLetter(numDNI.charAt(8));
    }

    private char getLastLetter(){
        return Character.toUpperCase(numDNI.charAt(8));
    }

    private int stringToInt(){
        return Integer.parseInt(numDNI.substring(1,8));
    }

    private int getASCII(int i){
        return numDNI.codePointAt(i);
    }

    private boolean checkValidASCII(int caracterASCII){
        return (caracterASCII > 47 && caracterASCII < 58);
    }

    private boolean checkCorrectFormat(){
        int i = 1;
        if(numDNI.length() == 9 && checkIsLetter() && getXletter() || getYletter() || getZletter()){
            do {
                esValido = checkValidASCII(getASCII(1));
                i++;
            } while (i < numDNI.length() - 1 && esValido);
        }
        return true;
    }

    private String setNumDNI( ){
        if(esValido && getXletter()){
            this.numDNI = "0" + this.numDNI.substring(1, 9);
        } else if(esValido && getYletter()){
            this.numDNI = "1" + this.numDNI.substring(1, 9);
        } else {
            this.numDNI = "2" + this.numDNI.substring(1, 9);
        }
        return this.numDNI;
    }

    private boolean isValid(){
        if(esValido){
            final char[] asignacionLetra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X','B', 'N',
                    'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
            setNumDNI();
            char letter = getLastLetter();
            int nie = stringToInt();
            int rest = nie % 23;
            esValido = (letter == asignacionLetra[rest]);
            return esValido;
        } else {
            return false;
        }
    }

    public boolean correctNIE(){
        return checkCorrectFormat() && isValid();
    }

}
