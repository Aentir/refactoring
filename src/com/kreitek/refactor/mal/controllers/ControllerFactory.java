package com.kreitek.refactor.mal.controllers;

import com.kreitek.refactor.mal.Controller;

public class ControllerFactory {

    public Controller ControllerDNI() {
        return new ControllerDNI();
    }

    public Controller ControllerNIE() {
        return new ControllerNIE();
    }

    public Controller ControllerCIF() {
        return new ControllerCIF();
    }
}
