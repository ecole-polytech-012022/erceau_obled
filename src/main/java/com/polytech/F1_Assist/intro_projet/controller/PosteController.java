package com.polytech.F1_Assist.intro_projet.controller;

import com.polytech.F1_Assist.intro_projet.model.Poste;
import com.polytech.F1_Assist.intro_projet.model.User;
import com.polytech.F1_Assist.intro_projet.service.PosteService;
import com.polytech.F1_Assist.intro_projet.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/postes")
@RestController
public class PosteController {

    private final PosteService posteService;

    public PosteController(PosteService posteService) {
        this.posteService = posteService;
    }

    @GetMapping("")
    public ResponseEntity<List<Poste>> getAllPostes() {

        List<Poste> postes = posteService.getAllPostes();

        return ResponseEntity.ok(postes);
    }

    @GetMapping("/{posteId}")
    public ResponseEntity<Integer> getMechanicByPosteId(@PathVariable Integer posteId) {

        Poste poste = posteService.getPosteById(posteId);

        if (poste == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(poste.getMechanic());
    }

    @GetMapping("/affectPosts")
    public ResponseEntity<List<Poste>> affectPosts()
    {
        return ResponseEntity.ok(posteService.getAllPostes());
    }

}
