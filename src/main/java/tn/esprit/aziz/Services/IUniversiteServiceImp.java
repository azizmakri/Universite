package tn.esprit.aziz.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aziz.Entities.Departement;
import tn.esprit.aziz.Entities.Etudiant;
import tn.esprit.aziz.Entities.Universite;
import tn.esprit.aziz.Repositories.EtudiantRepository;
import tn.esprit.aziz.Repositories.UniversiteRepository;

import java.util.List;

@Service        //cree moin une instance (bean) de cette classe
@AllArgsConstructor
@NoArgsConstructor
public class IUniversiteServiceImp implements IUnivresiteService{

    //@Autowired
    UniversiteRepository universiteRepository;


    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite getById(Integer IdUniversite) {
        return universiteRepository.findById(IdUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public void removeUniversite(Integer IdUniversite) {
        universiteRepository.deleteById(IdUniversite);
    }
}
