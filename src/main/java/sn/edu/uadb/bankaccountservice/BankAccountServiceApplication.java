package sn.edu.uadb.bankaccountservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.edu.uadb.bankaccountservice.entities.Compte;
import sn.edu.uadb.bankaccountservice.enums.AccounteType;
import sn.edu.uadb.bankaccountservice.repositories.CompteRepository;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            for (int i = 0; i < 10; i++) {
                Compte compte= Compte.builder()
                        .id(UUID.randomUUID().toString())
                        .sole(Math.random()*90000)
                        .date(new Date())
                        .type(Math.random()>0.5? AccounteType.COURANT:AccounteType.EPARGNE)
                        .devise("FCFA")

                        .build();
                compteRepository.save(compte);
            }
        };
    }
}
