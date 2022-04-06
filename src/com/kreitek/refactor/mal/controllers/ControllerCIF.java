package com.kreitek.refactor.mal.controllers;

import com.kreitek.refactor.mal.Controller;
import com.kreitek.refactor.mal.ID;
import com.kreitek.refactor.mal.identifications.CIF;

public class ControllerCIF implements Controller {
    public boolean validarID(ID tipo, String numID){
        CIF cif = new CIF(tipo, numID);
        System.out.println("CIF" + numID + " es:" + cif.correctCIF());
        return cif.correctCIF();
    }

}
