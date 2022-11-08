package tn.esprit.aziz.Services;

import tn.esprit.aziz.Entities.Departement;
import tn.esprit.aziz.Entities.Etudiant;

import java.util.List;

public interface IDepartementService {
    public Departement addDepartement(Departement d);
    public Departement updateDepartement(Departement d);
    public Departement getById(Integer IdDepartement);
    public List<Departement> getAllDepartement();
    public void removeDepartement(Integer IdDepartement);
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);

}
