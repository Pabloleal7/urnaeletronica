package com.example.urnaeletronica.repositories;

import com.example.urnaeletronica.models.Chapa;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ChapaRepository extends JpaRepository<Chapa,Long> {


}
