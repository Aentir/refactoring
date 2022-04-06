package com.kreitek.refactor.mal;

import com.kreitek.refactor.mal.controllers.ControllerFactory;

public class IdentificationDocument {

    ControllerFactory controllerFactory = new ControllerFactory();

    public int validarID(ID enumTipo, String numDNI) {

        switch (enumTipo) {
            case DNI:
                Controller ControllerDNI = controllerFactory.ControllerDNI();
                if (!ControllerDNI.validarID(enumTipo, numDNI)) return 0;
                return 1;

            case CIF:
                Controller ControllerCIF = controllerFactory.ControllerCIF();
                if (!ControllerCIF.validarID(enumTipo, numDNI)) return 0;
                return 1;

            case NIE:
                Controller ControllerNIE = controllerFactory.ControllerNIE();
                if (ControllerNIE.validarID(enumTipo, numDNI)) return 0;
                return 1;

            default:
                return -99;
        }
    }
}
