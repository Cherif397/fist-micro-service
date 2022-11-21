package sn.edu.uadb.bankaccountservice.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.edu.uadb.bankaccountservice.dto.CompteResponseDTO;
import sn.edu.uadb.bankaccountservice.dto.CompteRquestDTO;
import sn.edu.uadb.bankaccountservice.entities.Compte;
import sn.edu.uadb.bankaccountservice.repositories.CompteRepository;
import sn.edu.uadb.bankaccountservice.service.CompteService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class CompteController {
    CompteRepository compteRepository;
    CompteService compteService;

    @GetMapping(path = "/comptes")
    public List<Compte> listeCompte() {
        return compteRepository.findAll();
    }

    @GetMapping(path = "/comptes/{id}")
    public Compte findById(@PathVariable String id) {
        return compteRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Count %s not found ", id)));
    }

    @PostMapping(path = "/comptes")
    public CompteResponseDTO save(@RequestBody CompteRquestDTO compte) {
       return compteService.addCompte(compte);
    }

    @PutMapping(path = "/comptes/{id}")
    public Compte update(@PathVariable String id, @RequestBody Compte compte) {
        Compte cp = compteRepository.findById(id).orElseThrow();
        if (compte.getDate() != null) cp.setDate(compte.getDate());
        if (compte.getType() != null) cp.setType(compte.getType());
        if (compte.getSole() != null) cp.setSole(compte.getSole());
        if (compte.getDevise() != null) cp.setDevise(compte.getDevise());
        return compteRepository.save(cp);
    }

    @DeleteMapping(path = "/comptes/{id}")
    public void deleteCompte(@PathVariable String id) {
        compteRepository.deleteById(id);
    }
}
