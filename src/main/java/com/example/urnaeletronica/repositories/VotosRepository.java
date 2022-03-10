package com.example.urnaeletronica.repositories;

import com.example.urnaeletronica.models.Votos;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface VotosRepository extends JpaRepository<Votos,Long> {
}
