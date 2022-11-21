package sn.edu.uadb.bankaccountservice.entities;

import org.springframework.data.rest.core.config.Projection;
import sn.edu.uadb.bankaccountservice.enums.AccounteType;

@Projection(types = Compte.class,name = "p1")
public interface CompteProjection {
    public String getId();
    public AccounteType getType();
}
