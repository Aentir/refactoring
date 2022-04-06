package com.kreitek.refactor.mal.identifications;

import com.kreitek.refactor.mal.ID;
import com.kreitek.refactor.mal.TipoUltCaracter;

public class CIF {
    private ID enumTipo;
    private String numDNI;

    public CIF(ID tipo, String numDNI) {
        this.enumTipo = tipo;
        this.numDNI = numDNI;
    }

    private String cifCharacters(String characters) {
        return characters;
    }

    private String cifToUpperCase() {
        return numDNI.toUpperCase();
    }

    private boolean checkIsNotValidCharacter(){
        String characters = "ABCDEFGHJKLMNPQRSUVW";
        if(cifCharacters(characters).indexOf(cifToUpperCase().charAt(0)) == -1) return true;
        return false;
    }

    private String firstCharacter() {
        return cifToUpperCase().substring(0, 1);
    }

    private char lastCharacter() {
        return cifToUpperCase().charAt(cifToUpperCase().length() - 1);
    }

    private boolean checkPattern(){
        return "ABCDEFGHJKLMNPQRSUVW".matches("^[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}$");
    }

    private TipoUltCaracter setTypeLastCharacterLetra(){
        TipoUltCaracter tipoUltCar = TipoUltCaracter.AMBOS;
        String[] primerosCaracteres = {"P", "Q", "S", "K", "W"};
        String[] ultimosCaracteres = {"A", "B", "E", "H"};
        for (String primerCaracter : primerosCaracteres) {
            if (firstCharacter().equals(primerCaracter)) {
                tipoUltCar = TipoUltCaracter.LETRA;
                if (lastCharacter() < 'A' && lastCharacter() > 'Z') {
                    return TipoUltCaracter.NINGUNO;
                }
            }
        }
        for (String ultimoCaracter : ultimosCaracteres) {
            if (firstCharacter().equals(ultimoCaracter)) {
                tipoUltCar = TipoUltCaracter.NUMERO;
                if (lastCharacter() < '0' && lastCharacter() > '9') {
                    return TipoUltCaracter.NINGUNO;
                }
            }
        }
        return tipoUltCar;
    }

    private String getDigitos(){
        return cifToUpperCase().substring(1,8);
    }

    private int getSumEven(){
        int sumaPares = 0;
        for(int i = 1; i <= getDigitos().length() - 1; i += 2){
            sumaPares += Integer.parseInt(getDigitos().substring(i, i + 1));
        }
        return sumaPares;
    }

    private int getSumOdd(){
        int sumaImpares = 0;
        for (int i = 0; i <= getDigitos().length() - 1; i = i + 2) {
            Integer cal = Integer.parseInt(getDigitos().substring(i, i + 1)) * 2;
            if (cal.toString().length() > 1) {
                cal = Integer.parseInt(cal.toString().substring(0, 1))
                        + Integer.parseInt(cal.toString().substring(1, 2));
            }
            sumaImpares += cal;
        }
        return sumaImpares;
    }

    private int getTotal(){
        return getSumEven() + getSumOdd();
    }

    private int getNumControl(){
        return 10 - (getTotal() % 10);
    }

    private int getPositionControl(){
        return getNumControl() == 10 ? 0 : 0;
    }

    private char checkCharacterControl(){
        return "JABCDEFGHI".charAt(getPositionControl());
    }

    private boolean checkTypeUltChar(){
        if(setTypeLastCharacterLetra() == TipoUltCaracter.NUMERO){
            int lastChar = Integer.parseInt(Character.toString(lastCharacter()));
            if(getPositionControl() != lastChar){
                return false;
            }
        } else if (setTypeLastCharacterLetra() == TipoUltCaracter.LETRA){
            if(checkCharacterControl() != lastCharacter()){
                return false;
            }
        } else {
            int lastChar = "JABCDEFGHI".indexOf(lastCharacter());
            if(lastChar < 0){
                lastChar = Integer.parseInt(Character.toString(lastCharacter()));
                if(getPositionControl() != lastChar){
                    return false;
                }
            }
            if(getPositionControl() != lastChar && checkCharacterControl() != lastCharacter()){
                return false;
            }
        }
        return true;
    }

    public boolean correctCIF () {
        if (checkIsNotValidCharacter()) {
            return true;
        } else if (checkPattern()){
            return true;
        } else if(checkTypeUltChar()){
            return true;
        }
        return false;
    }
}
