package com.polytech.F1_Assist.intro_projet.service;

import com.polytech.F1_Assist.intro_projet.model.Poste;
import com.polytech.F1_Assist.intro_projet.model.User;
import com.polytech.F1_Assist.intro_projet.repository.PosteRepository;
import com.polytech.F1_Assist.intro_projet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PosteService {

    private final PosteRepository repository;

    public PosteService(PosteRepository repository) {
        this.repository = repository;
        this.initPostes();
    }
    public List<User> list = new ArrayList<>();
    public Integer id = 1;

    public void initPostes() {
        Poste poste1 = new Poste();
        poste1.setTyre("ArD");
        poste1.setActivity("Pistolet");
        poste1.setMechanic(1);

        Poste poste2 = new Poste();
        poste2.setTyre("ArD");
        poste2.setActivity("Retirer");

        Poste poste3 = new Poste();
        poste3.setTyre("ArD");
        poste3.setActivity("Placer");

        Poste poste4 = new Poste();
        poste4.setTyre("ArG");
        poste4.setActivity("Pistolet");

        Poste poste5 = new Poste();
        poste5.setTyre("ArG");
        poste5.setActivity("Retirer");

        Poste poste6 = new Poste();
        poste6.setTyre("ArG");
        poste6.setActivity("Placer");

        Poste poste7 = new Poste();
        poste7.setTyre("AvD");
        poste7.setActivity("Pistolet");

        Poste poste8 = new Poste();
        poste8.setTyre("AvD");
        poste8.setActivity("Retirer");

        Poste poste9 = new Poste();
        poste9.setTyre("AvD");
        poste9.setActivity("Placer");

        Poste poste10 = new Poste();
        poste10.setTyre("AvG");
        poste10.setActivity("Pistolet");

        Poste poste11 = new Poste();
        poste11.setTyre("AvG");
        poste11.setActivity("Retirer");

        Poste poste12 = new Poste();
        poste12.setTyre("AvG");
        poste12.setActivity("Placer");

        this.repository.save(poste1);
        this.repository.save(poste2);
        this.repository.save(poste3);
        this.repository.save(poste4);
        this.repository.save(poste5);
        this.repository.save(poste6);
        this.repository.save(poste7);
        this.repository.save(poste8);
        this.repository.save(poste9);
        this.repository.save(poste10);
        this.repository.save(poste11);
        this.repository.save(poste12);

    }

    public List<Poste> getAllPostes() {
        return this.repository.findAll();
    }

    public Poste getPosteById(Integer id) {
        Optional<Poste> found = this.repository.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public Poste createPoste(Poste givenPoste) {
        if (givenPoste.getActivity() != null && givenPoste.getTyre() != null) {
            return this.repository.save(givenPoste);
        }
        return null;
    }

    public boolean deletePosteById(Integer posteId) {
        Poste found = getPosteById(posteId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }
}
