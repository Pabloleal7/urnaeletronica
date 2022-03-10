package com.example.urnaeletronica.services;

import com.example.urnaeletronica.models.Chapa;
import com.example.urnaeletronica.models.Turma;
import com.example.urnaeletronica.models.TurnoEnum;
import com.example.urnaeletronica.models.Votos;
import com.example.urnaeletronica.repositories.ChapaRepository;
import com.example.urnaeletronica.repositories.TurmaRepository;
import com.example.urnaeletronica.repositories.VotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UrnaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ChapaRepository chapaRepository;

    @Autowired
    private VotosRepository votosRepository;

    public List<Turma> findAllTurmas() {
        return turmaRepository.findAll();
    }

    public Turma findTurma(Long id) {
        return turmaRepository.getById(id);
    }

    public Integer votosPorChapa(Long id){

        Integer totalVotos = 0;


        for (Votos voto: votosRepository.findAll()) {
            if(voto.getChapa().getId() == id){
                System.out.println("aqui");
                System.out.println(totalVotos);
                totalVotos++;
            }

        }

        return totalVotos;

    }

    public List<Chapa> findAllChapasPorTurma(Long id) {

        List<Chapa> chapas = new ArrayList<>();

        for (Chapa chapa : chapaRepository.findAll()) {
            if (chapa.getTurma().getId() == id) {
                chapas.add(chapa);
            }


        }

        return chapas;


    }

    public List<Chapa> findAllChapas() {


        return chapaRepository.findAll();


    }

   /* @PostConstruct
    public void cadastrar() {

       *//* Turma turma = new Turma();
        turma.setNome("1º SÉRIE INFORMÁTICA -EPI");
        turma.setTurno(TurnoEnum.MATUTINO);
        turmaRepository.save(turma);

        Turma turma1 = new Turma();
        turma1.setNome("1º SÉRIE ADMINISTRAÇÃO-EPI");
        turma1.setTurno(TurnoEnum.MATUTINO);
        turmaRepository.save(turma1);

        Turma turma2 = new Turma();
        turma2.setNome("1º ANÁLISE CLÍNICA");
        turma2.setTurno(TurnoEnum.MATUTINO);
        turmaRepository.save(turma2);

        Turma turma3 = new Turma();
        turma3.setNome("2º INFORMÁTICA");
        turma3.setTurno(TurnoEnum.MATUTINO);
        turmaRepository.save(turma3);

        Turma turma4 = new Turma();
        turma4.setNome("3ª SÉRIE ANÁLISE CLÍNICAS");
        turma4.setTurno(TurnoEnum.MATUTINO);
        turmaRepository.save(turma4);

        Turma turma5 = new Turma();
        turma5.setNome("3ª SÉRIE ADMINISTRAÇÃO");
        turma5.setTurno(TurnoEnum.MATUTINO);
        turmaRepository.save(turma5);

        Turma turma6 = new Turma();
        turma6.setNome("MÓD I. RECURSOS HUMANOS-PROSUB");
        turma6.setTurno(TurnoEnum.MATUTINO);
        turmaRepository.save(turma5);

        Turma turma7 = new Turma();
        turma7.setNome("MÓD I. RECURSOS HUMANOS-PROSUB");
        turma7.setTurno(TurnoEnum.MATUTINO);
        turmaRepository.save(turma5);*//*

       *//*
        Turma turma = new Turma();
        turma.setTurno(TurnoEnum.NOTURNO);
        turma.setNome("1 ADM");
        Chapa chapa = new Chapa();
        chapa.setLider("Globesvaldo");
        chapa.setViceLider("Jacbergison");
        chapa.setTurma(turma);
        turmaRepository.save(turma);
        chapaRepository.save(chapa);*//*


    }*/


}
