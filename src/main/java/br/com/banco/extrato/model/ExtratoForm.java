package br.com.banco.extrato.model;

import lombok.Data;

@Data
public class ExtratoForm {

    private Integer id;
    private String dataInicio;
    private String dataFim;
    private String operador;

    
}
