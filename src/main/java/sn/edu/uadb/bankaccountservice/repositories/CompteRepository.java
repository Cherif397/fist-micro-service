package sn.edu.uadb.bankaccountservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import sn.edu.uadb.bankaccountservice.entities.Compte;
import sn.edu.uadb.bankaccountservice.enums.AccounteType;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository <Compte,String>{

    @RestResource(path = "/byType")
    List<Compte> findByType(@Param("t") AccounteType type);
}
