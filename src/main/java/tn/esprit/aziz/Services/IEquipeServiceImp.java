package tn.esprit.aziz.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aziz.Entities.Equipe;
import tn.esprit.aziz.Repositories.EquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class IEquipeServiceImp implements IEquipeService{

    //@Autowired
    EquipeRepository equipeRepository;

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe getById(Integer IdEquipe) {
        return equipeRepository.findById(IdEquipe).orElse(null);
    }

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public void removeEquipe(Integer IdEquipe) {
        equipeRepository.deleteById(IdEquipe);
    }
}
