package com.example.urnaeletronica.controllers;

import com.example.urnaeletronica.models.Turma;
import com.example.urnaeletronica.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping()
    public List findAll() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return turmaRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping()
    public Turma create(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Turma turma) {
        return turmaRepository.findById(id)
                .map(record -> {
                    record.setNome(turma.getNome());
                    record.setTurno(turma.getTurno());
                    Turma updated = turmaRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        return turmaRepository.findById(id)
                .map(record -> {
                    turmaRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}

