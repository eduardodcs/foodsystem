package com.fiap.soat.foodsystem.external.client;


import com.fiap.soat.foodsystem.adapters.gateways.client.IPagamentoClient;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

@Component
public class PagamentoClientImpl implements IPagamentoClient {


    public JsonObject gerarSolicitacaoPagamento(JsonObject jsonPagamentoRequest) {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://sandbox.api.pagseguro.com/orders";
        String token = "B1376D03D04847EAA60EB65507B08612";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonPagamentoRequest.toString()))
                .build();

        HttpResponse<String> httpResponse = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    System.out.println("Status Code: " + response.statusCode());
                    System.out.println("Response Body: " + response.body());
                    return response;
                }).join();

        System.out.println(httpResponse.body());

        return JsonParser.parseString(httpResponse.body())
                .getAsJsonObject();
    }

}
