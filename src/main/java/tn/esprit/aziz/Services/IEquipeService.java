package tn.esprit.aziz.Services;

import tn.esprit.aziz.Entities.Contrat;
import tn.esprit.aziz.Entities.Equipe;

import java.util.List;

public interface IEquipeService {
    public Equipe addEquipe(Equipe c);
    public Equipe updateEquipe(Equipe c);
    public Equipe getById(Integer IdEquipe);
    public List<Equipe> getAllEquipe();
    public void removeEquipe(Integer IdEquipe);
}
