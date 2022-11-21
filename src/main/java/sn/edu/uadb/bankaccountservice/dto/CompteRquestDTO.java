package sn.edu.uadb.bankaccountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.edu.uadb.bankaccountservice.enums.AccounteType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompteRquestDTO {
    private Double sole;
    private String devise;
    private AccounteType type;
}
