package com.example.demo.web;

import com.example.demo.dao.OffreRepository;
import com.example.demo.entities.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Offres")
public class RestOffres {

    @Autowired
    OffreRepository offreRepository;

    // GET /Offres : toutes les offres
    @GetMapping
    public List<Offre> getAll() {
        return offreRepository.findAll();
    }

    // GET /Offres/1 : une offre
    @GetMapping("/{uid}")
    public Offre getbyid(@PathVariable Long uid) {
        return offreRepository.findById(uid).get();
    }

    // POST /Offres : ajouter une offre
    @PostMapping
    public Offre saveoffre(@RequestBody Offre newoffre) {
        return offreRepository.save(newoffre);
    }

    // PUT /Offres/4 : modifier une offre
    @PutMapping("/{id}")
    public Offre updateoffre(@PathVariable Long id, @RequestBody Offre offre) {
        offre.setCode(id);
        return offreRepository.save(offre);
    }

    // DELETE /Offres/4 : supprimer une offre
    @DeleteMapping("/{id}")
    public void deleteoffre(@PathVariable Long id) {
        offreRepository.deleteById(id);
    }
}