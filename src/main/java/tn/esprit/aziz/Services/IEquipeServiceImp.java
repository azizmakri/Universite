package tn.esprit.aziz.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.aziz.Entities.Contrat;
import tn.esprit.aziz.Entities.Equipe;
import tn.esprit.aziz.Entities.Etudiant;
import tn.esprit.aziz.Entities.Niveau;
import tn.esprit.aziz.Repositories.EquipeRepository;
import tn.esprit.aziz.Repositories.EtudiantRepository;
import tn.esprit.aziz.utilities.HelperClass;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class IEquipeServiceImp implements IEquipeService{

    //@Autowired
    EquipeRepository equipeRepository;
    EtudiantRepository etudiantRepository;

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

    /*@Scheduled(fixedRate = 60000)
    @Override
    public void faireEvoluerEquipes() {
        int nbrValide=0;
        List<Equipe>equipes=equipeRepository.findAll();
        List<Etudiant>etudiants=null;
        List<Contrat>contrats=null;
        for (Equipe e:equipes) {
            nbrValide=0;
            equipes.stream().forEach(equipe -> equipe.getEtudiants());

            for (Etudiant et:etudiants) {
                contrats=et.getContrats();

                for (Contrat c:contrats) {
                    if (HelperClass.DiffTwoDate(c.getDateDebutContrat(),c.getDateFinContrat())>=365){
                        nbrValide++;
                    }
                }
            }
            if (nbrValide>=3){
                if (e.getNiveau().equals(Niveau.JUNIOR)){
                    e.setNiveau(Niveau.SENIOR);
                }
                else if(e.getNiveau().equals(Niveau.SENIOR)){
                    e.setNiveau(Niveau.EXPERT);
                }
            }
        }
    }*/
}
