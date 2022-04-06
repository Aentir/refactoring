package com.kreitek.refactor.mal.controllers;

import com.kreitek.refactor.mal.Controller;
import com.kreitek.refactor.mal.ID;
import com.kreitek.refactor.mal.identifications.DNI;

public class ControllerDNI implements Controller {
    public boolean validarID(ID tipo, String numID) {
        DNI dni = new DNI(tipo, numID);
        System.out.println( "DNI " + numID + " es: " + dni.correctDNI());
        return dni.correctDNI();
    }

}
