package com.example.urnaeletronica.models;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Chapa {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lider;

    private String viceLider;

    @ManyToOne
    private Turma turma;


}
