package com.example.urnaeletronica.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@ToString
@Getter
@Setter
public class ResultadoTurmaDTO {

    private String turma;
    private List<ChapaDTO> chapas;




}
