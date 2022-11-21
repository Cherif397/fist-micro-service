package sn.edu.uadb.bankaccountservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.edu.uadb.bankaccountservice.dto.CompteResponseDTO;
import sn.edu.uadb.bankaccountservice.dto.CompteRquestDTO;
import sn.edu.uadb.bankaccountservice.entities.Compte;
import sn.edu.uadb.bankaccountservice.enums.AccounteType;
import sn.edu.uadb.bankaccountservice.repositories.CompteRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class CompteServiceImpl implements CompteService {
    private CompteRepository compteRepository;
    @Override
    public CompteResponseDTO addCompte(CompteRquestDTO compteRquestDTO) {
        Compte compte=Compte.builder()
                .id(UUID.randomUUID().toString())
                .date(new Date())
                .sole(compteRquestDTO.getSole())
                .type(compteRquestDTO.getType())
                .devise(compteRquestDTO.getDevise())
                .build();
        Compte compte1=compteRepository.save(compte);
        CompteResponseDTO responseDTO=CompteResponseDTO.builder()
                .id(compte1.getId())
                .date(compte1.getDate())
                .devise(compte1.getDevise())
                .type(compte1.getType())
                .sole(compte1.getSole())
                .build();
        return responseDTO;
    }

    @Override
    public List<Compte> allCompt() {
        return compteRepository.findAll();
    }
}
