package sn.edu.uadb.bankaccountservice.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import sn.edu.uadb.bankaccountservice.dto.CompteResponseDTO;
import sn.edu.uadb.bankaccountservice.entities.Compte;

@Component
public class CompteMapper {
    public CompteResponseDTO fromCompt(Compte compte){
        CompteResponseDTO responseDTO=new CompteResponseDTO();
        BeanUtils.copyProperties(compte,responseDTO);
        return responseDTO;
    }
}
