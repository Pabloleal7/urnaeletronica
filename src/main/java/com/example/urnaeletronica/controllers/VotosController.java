package com.example.urnaeletronica.controllers;
import com.example.urnaeletronica.models.Chapa;
import com.example.urnaeletronica.models.Votos;
import com.example.urnaeletronica.repositories.ChapaRepository;
import com.example.urnaeletronica.repositories.VotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("votos")
public class VotosController {
    @Autowired
    private VotosRepository repository;

    @GetMapping()
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping()
    public Votos create(@RequestBody Votos votos) {
        return repository.save(votos);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Votos votos) {
        return repository.findById(id)
                .map(record -> {
                    record.setChapa(votos.getChapa());
                    Votos updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}

