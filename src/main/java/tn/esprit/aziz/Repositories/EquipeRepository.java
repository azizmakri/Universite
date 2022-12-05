package tn.esprit.aziz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aziz.Entities.Equipe;
import tn.esprit.aziz.Entities.Etudiant;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    List<Equipe> findByEtudiantsContains(Etudiant e);
}
