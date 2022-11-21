package sn.edu.uadb.bankaccountservice.service;

import sn.edu.uadb.bankaccountservice.dto.CompteResponseDTO;
import sn.edu.uadb.bankaccountservice.dto.CompteRquestDTO;
import sn.edu.uadb.bankaccountservice.entities.Compte;

import java.util.List;

public interface CompteService {
    public CompteResponseDTO addCompte(CompteRquestDTO compteRquestDTO);
    public List<Compte> allCompt();
}
