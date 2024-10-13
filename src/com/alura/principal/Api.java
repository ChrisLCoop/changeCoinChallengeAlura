package com.alura.principal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    String dolarEstadounidense ="USD";
    String pesoArgentino ="ARS" ;
    String realBrasil ="BRL";
    String pesoColombiano ="COP";

    double valorConversion1;
    double valorConversion2;
    double valorConversion3;

    //urls para saber el tipo de cambio de los paises segun el challenge
    String url1 = "https://v6.exchangerate-api.com/v6/369bea7047e294b188feee2a/pair/"+dolarEstadounidense+"/"+pesoArgentino;
    String url2 = "https://v6.exchangerate-api.com/v6/369bea7047e294b188feee2a/pair/"+dolarEstadounidense+"/"+realBrasil;
    String url3 = "https://v6.exchangerate-api.com/v6/369bea7047e294b188feee2a/pair/"+dolarEstadounidense+"/"+pesoColombiano;

    public double getValorConversion1() {
        return valorConversion1;
    }

    public double getValorConversion2() {
        return valorConversion2;
    }

    public double getValorConversion3() {
        return valorConversion3;
    }

    void consultaApi() throws IOException, InterruptedException {

        //llamada de api para extraer los datos de los 3

        //primer cambio
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url1))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String primerCambio = response.body();
        //System.out.println(primerCambio);



        //segundo cambio
        HttpClient client2 = HttpClient.newHttpClient();
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(url2))
                .build();

        HttpResponse<String> response2 = client2
                .send(request2, HttpResponse.BodyHandlers.ofString());
        String segundoCambio = response2.body();
        //System.out.println(segundoCambio);


        //tercer cambio
        HttpClient client3 = HttpClient.newHttpClient();
        HttpRequest request3 = HttpRequest.newBuilder()
                .uri(URI.create(url3))
                .build();

        HttpResponse<String> response3 = client3
                .send(request3, HttpResponse.BodyHandlers.ofString());
        String tercerCambio = response3.body();
        //System.out.println(tercerCambio);


        //extraccion unicamente del cambio con GSON--------------------

        Gson gson = new Gson();

        //respuesta 1
        JsonObject conversion1 = gson.fromJson(primerCambio, JsonObject.class);
        valorConversion1 = conversion1.get("conversion_rate").getAsDouble();
        //System.out.println("conversion 1: "+ valorConversion1);


        //respuesta 2
        JsonObject conversion2 = gson.fromJson(segundoCambio, JsonObject.class);
        valorConversion2 = conversion2.get("conversion_rate").getAsDouble();
        //System.out.println("conversion 2: "+ valorConversion2);

        //respuesta 3
        JsonObject conversion3 = gson.fromJson(tercerCambio, JsonObject.class);
        valorConversion3 = conversion3.get("conversion_rate").getAsDouble();
        //System.out.println("conversion 3: "+ valorConversion3);
    }
}
