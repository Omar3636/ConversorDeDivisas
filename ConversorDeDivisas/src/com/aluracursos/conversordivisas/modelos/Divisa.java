package com.aluracursos.conversordivisas.modelos;

import java.util.HashMap;

public record Divisa(String base_code, HashMap<String,Double> conversion_rates) {
}
