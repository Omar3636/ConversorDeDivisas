package com.aluracursos.conversordivisas.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPRequest {

    public Divisa busqueda(String divisa) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/78b177d028930e9848e65108/latest/" + divisa.replace(" ", "+"));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

            try {
                HttpResponse<String> response;
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(), Divisa.class);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

    }

}
