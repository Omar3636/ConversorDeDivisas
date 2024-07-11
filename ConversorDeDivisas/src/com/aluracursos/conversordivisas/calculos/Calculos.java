package com.aluracursos.conversordivisas.calculos;
import com.aluracursos.conversordivisas.modelos.RegistroDivisas;

public class Calculos {
    private String divisaUno;
    private String divisaDos;
    private double cantidad;
    private double totalConversion;

    public double calculaConversion(String divisaUno, String divisaDos, double cantidad, RegistroDivisas divisas) {
        this.divisaUno = divisaUno;
        this.divisaDos = divisaDos;
        this.cantidad = cantidad;
        return this.totalConversion = divisas.getDivisas(divisaDos)*cantidad;
    }
}
