package tn.esprit.aziz.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aziz.Entities.Departement;
import tn.esprit.aziz.Entities.Etudiant;
import tn.esprit.aziz.Entities.Universite;
import tn.esprit.aziz.Repositories.DepartementRepository;
import tn.esprit.aziz.Repositories.UniversiteRepository;

import java.util.List;

@Service        //cree moin une instance (bean) de cette classe
//@AllArgsConstructor
//@NoArgsConstructor
public class IDepartementServiceImp implements IDepartementService{

   @Autowired
    DepartementRepository departementRepository;
   @Autowired
    UniversiteRepository universiteRepository;
    @Override
    public Departement addDepartement(Departement d) {

        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {

        return departementRepository.save(d);
    }

    @Override
    public Departement getById(Integer IdDepartement) {

        return departementRepository.findById(IdDepartement).orElse(null);
    }

    @Override
    public List<Departement> getAllDepartement() {

        return departementRepository.findAll();
    }

    @Override
    public void removeDepartement(Integer IdDepartement) {

        departementRepository.deleteById(IdDepartement);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite= universiteRepository.findById(idUniversite).orElse(null);
        Departement departement= departementRepository.findById(idDepartement).orElse(null);
        if(universite !=null && departement!=null){
            universite.getDepartemments().add(departement);
            universiteRepository.save(universite);
        }

    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
       Universite universite=universiteRepository.findById(idUniversite).orElse(null);
        if(universite!=null){
            return  universite.getDepartemments();
        }
        return null;

        }


}
