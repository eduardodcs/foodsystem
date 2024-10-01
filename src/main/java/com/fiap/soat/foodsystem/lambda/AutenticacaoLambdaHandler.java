package com.fiap.soat.foodsystem.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class AutenticacaoLambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        // Capturar o CPF enviado no corpo da requisição
        String cpf = request.getBody(); // O body pode estar em JSON
        // Validação e lógica de autenticação
        boolean autenticado = validarCpfNoDynamoDB(cpf);

        // Criar resposta da API
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        if (autenticado) {
            response.setStatusCode(200);
            response.setBody("{\"message\": \"Autenticado com sucesso!\"}");
        } else {
            response.setStatusCode(401);
            response.setBody("{\"message\": \"CPF não encontrado.\"}");
        }
        return response;
    }

    private boolean validarCpfNoDynamoDB(String cpf) {
        // Implementar lógica de consulta ao DynamoDB
        return true; // Retornar true ou false conforme a consulta
    }
}
