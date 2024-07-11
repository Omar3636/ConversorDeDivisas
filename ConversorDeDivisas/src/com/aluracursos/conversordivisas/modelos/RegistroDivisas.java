package com.aluracursos.conversordivisas.modelos;

import java.util.HashMap;

public class RegistroDivisas {
    HashMap<String,Double> divisas;


    public RegistroDivisas(Divisa divisa) {
        this.divisas = divisa.conversion_rates();
    }

    public double getDivisas(String moneda) {
        return divisas.get(moneda).doubleValue();
    }
}
