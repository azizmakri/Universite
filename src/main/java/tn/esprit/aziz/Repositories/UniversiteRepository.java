package tn.esprit.aziz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aziz.Entities.Departement;
import tn.esprit.aziz.Entities.Universite;

import java.util.List;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {

}
