package br.com.stelo.vendedor.cadastro.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseMessage {

    private String message;
}
