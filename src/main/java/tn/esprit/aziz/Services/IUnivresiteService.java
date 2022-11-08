package tn.esprit.aziz.Services;

import tn.esprit.aziz.Entities.Contrat;
import tn.esprit.aziz.Entities.Departement;
import tn.esprit.aziz.Entities.Universite;

import java.util.List;

public interface IUnivresiteService {
    public Universite addUniversite(Universite c);
    public Universite updateUniversite(Universite c);
    public Universite getById(Integer IdUniversite);
    public List<Universite> getAllUniversite();
    public void removeUniversite(Integer IdUniversite);
}
