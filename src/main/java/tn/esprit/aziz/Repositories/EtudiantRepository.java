package tn.esprit.aziz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aziz.Entities.Equipe;
import tn.esprit.aziz.Entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    public List<Etudiant> findEtudiantsByDepartementIdDepartement(int idDepartement);
    public Etudiant findByNomEAndPrenomE(String NomE, String prenomE);
    //List<Etudiant> findByEquipe(Equipe e);
}
