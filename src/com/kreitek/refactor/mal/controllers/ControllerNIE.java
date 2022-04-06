package com.kreitek.refactor.mal.controllers;

import com.kreitek.refactor.mal.Controller;
import com.kreitek.refactor.mal.ID;
import com.kreitek.refactor.mal.identifications.NIE;

public class ControllerNIE implements Controller {
    public boolean validarID(ID tipo, String numID){
        NIE nie = new NIE(tipo, numID);
        System.out.println("NIE" + numID + " es:" + nie.correctNIE());
    return nie.correctNIE();
    }
}