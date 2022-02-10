package com.polytech.F1_Assist.intro_projet.repository;

import com.polytech.F1_Assist.intro_projet.model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Integer> { // using JpaRepository super class
}
