package com.kreitek.refactor.mal;

class  Main
{
    public static void main(String args[])
    {
        initApp();

        IdentificationDocument identificationDocument = new IdentificationDocument();

        //DNI correcto
        identificationDocument.validarID(ID.DNI, "11111111H");

        //DNI incorrecto
        identificationDocument.validarID(ID.DNI, "24324356A");

        //NIE correcto
        identificationDocument.validarID(ID.NIE, "X0932707B");

        //NIE incorrecto
        identificationDocument.validarID(ID.NIE, "Z2691139Z");

        //CIF correcto
        identificationDocument.validarID(ID.CIF, "W9696294I");

        //CIF incorrecto
        identificationDocument.validarID(ID.CIF, "W9696294A");
    }

    private static void initApp() {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");
    }
}