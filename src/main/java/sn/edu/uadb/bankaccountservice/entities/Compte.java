package sn.edu.uadb.bankaccountservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.edu.uadb.bankaccountservice.enums.AccounteType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Compte {
    @Id
    private String id;
    private Double sole;

    private Date date;
    private String devise;
    @Enumerated(EnumType.STRING)
    private AccounteType type;
}
