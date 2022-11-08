package tn.esprit.aziz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aziz.Entities.Contrat;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
    public int findContratByArchiveIsFalseAndEtudiantNomEAndEtudiantPrenomE(String nomE, String prenomE);
}
