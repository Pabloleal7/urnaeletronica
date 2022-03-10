package com.example.urnaeletronica.controllers;
import com.example.urnaeletronica.models.Chapa;
import com.example.urnaeletronica.repositories.ChapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("chapa")
public class ChapaController {
    @Autowired
    private ChapaRepository repository;

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
    public Chapa create(@RequestBody Chapa chapa) {
        return repository.save(chapa);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody Chapa chapa) {
        return repository.findById(id)
                .map(record -> {
                    record.setTurma(chapa.getTurma());
                    record.setLider(chapa.getLider());
                    record.setViceLider(chapa.getViceLider());
                    Chapa updated = repository.save(record);
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

