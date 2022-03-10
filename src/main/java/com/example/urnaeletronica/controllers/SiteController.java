package com.example.urnaeletronica.controllers;

import com.example.urnaeletronica.models.Chapa;
import com.example.urnaeletronica.models.ChapaDTO;
import com.example.urnaeletronica.models.ResultadoTurmaDTO;
import com.example.urnaeletronica.models.Turma;
import com.example.urnaeletronica.services.UrnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SiteController {

    @Autowired
    private UrnaService urnaService;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/cadastrarturma")
    public String cadastrarTurma() {
        return "cadastrarturma";
    }

    @GetMapping("/cadastrarchapa")
    public String cadastrarChapa(Model model) {

        List<Turma> turmas = urnaService.findAllTurmas();
        model.addAttribute("turmas", turmas);

        return "cadastrarchapa";
    }

    @GetMapping("/listarturmas")
    public String listarTurmas(Model model) {

        List<Turma> turmas = urnaService.findAllTurmas();
        model.addAttribute("turmas", turmas);


        return "listarturmas";
    }

    @GetMapping("/listarturmas/{id}")
    public String listarTurmas(@PathVariable Long id, Model model) {
        Turma turma = urnaService.findTurma(id);

        List<Chapa> chapas = urnaService.findAllChapasPorTurma(id);
        model.addAttribute("turma", turma);
        model.addAttribute("chapas", chapas);


        return "listarturma";
    }


    @GetMapping("/resultados")
    public String resultados(Model model) {
        List<ResultadoTurmaDTO> resultados = new ArrayList<>();


        for (Turma turma : urnaService.findAllTurmas()) {
            ResultadoTurmaDTO resultado = new ResultadoTurmaDTO();

            resultado.setTurma(turma.getNome() + "  -  " + turma.getTurno());

            List<ChapaDTO> chapasDTO = new ArrayList<>();

            for (Chapa chapa : urnaService.findAllChapas()) {

                ChapaDTO chapaDTO = new ChapaDTO();

                if (chapa.getTurma().getId().equals(turma.getId())) {
                    chapaDTO.setLider(chapa.getLider());
                    chapaDTO.setViceLider(chapa.getViceLider());
                    chapaDTO.setVotos(urnaService.votosPorChapa(chapa.getId()));
                    chapasDTO.add(chapaDTO);

                }

            }

            resultado.setChapas(chapasDTO);
            System.out.println(resultado.getChapas().size());


            resultados.add(resultado);

        }


        model.addAttribute("resultados", resultados);
        return "resultados";
    }


    @GetMapping("/iniciarvotacao/{id}")
    public String turmaVotacao(@PathVariable Long id, Model model) {
        Turma turma = urnaService.findTurma(id);
        List<Chapa> chapas = urnaService.findAllChapasPorTurma(id);
        model.addAttribute("chapas", chapas);
        model.addAttribute("turma", turma);

        return "votacao";
    }

    @GetMapping("/iniciarvotacao")
    public String turmasVotacao(Model model) {
        List<Turma> turmas = urnaService.findAllTurmas();

        model.addAttribute("turmas", turmas);
        return "turmasvotacao";
    }

}
