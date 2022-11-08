package tn.esprit.aziz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.aziz.Entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
}
