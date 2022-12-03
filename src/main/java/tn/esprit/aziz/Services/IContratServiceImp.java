package tn.esprit.aziz.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.aziz.Entities.Contrat;
import tn.esprit.aziz.Entities.Equipe;
import tn.esprit.aziz.Entities.Etudiant;
import tn.esprit.aziz.Repositories.ContratRepository;
import tn.esprit.aziz.Repositories.EtudiantRepository;
import tn.esprit.aziz.utilities.HelperClass;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
//@AllArgsConstructor
//@NoArgsConstructor
@Slf4j//log lel journalisation
public class IContratServiceImp implements IContratService{

    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat getById(Integer IdContrat) {
        return contratRepository.findById(IdContrat).orElse(null);
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public void removeContrat(Integer IdContrat) {
        contratRepository.deleteById(IdContrat);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        /*
        List<Etudiant> etudiants =etudiantRepository.findAll();
        List<Contrat> contrats = null;
        List<Contrat> contratsValides = null;
        Etudiant etudiant = null;
        for (Etudiant i:etudiants) {
            if (i.getNomE().equals(nomE)&&i.getPrenomE().equals(prenomE)){
                contrats=i.getContrats();
                etudiant=i;
            }
        }
        if (!contrats.isEmpty()){
        for (Contrat ct:contrats) {
            if (ct.getArchive()==false){
                contratsValides.add(ct);
            }
        }
        }*/
        Etudiant etudiant=etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
        if (contratRepository.findContratByArchiveIsFalseAndEtudiantNomEAndEtudiantPrenomE(nomE,prenomE)<5){
            etudiant.getContrats().add(ce);
            return contratRepository.save(ce);
        }
        return null;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats=contratRepository.findAll();
        int i=0;
        for (Contrat ct:contrats) {
            if (ct.getDateDebutContrat().toString().equals(startDate.toString())&&ct.getDateFinContrat().toString().equals(endDate.toString())){
                i++;
            }
        }
        return i;
    }

    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.findAll();
        // SimpleDateFormat df=new SimpleDateFormat("DD/MM/YYYY");
        //  String SD= startDate.toString();
        // String ED= endDate.toString();
        // Date dateA=df.parse(String SD);
        // Date dateB=df.parse(String ED);
        long diff = endDate.getTime() - startDate.getTime();
        double chiffreAffaire = 0;
        //double resultat =0 ;
        for (Contrat ct : contrats) {
            if (ct.getArchive() == false) {
                if ((ct.getDateDebutContrat().before(startDate)) && (ct.getDateFinContrat().after(endDate))) {

                    double diffMois = diff / (1000 * 60 * 60 * 24 * 30);
                    double resultat =0 ;
                    switch (ct.getSpecialite()) {
                        case IA:
                            chiffreAffaire =+ diffMois * 300;
                            break;
                        case RESEAUX:
                            chiffreAffaire =+ diffMois * 350;
                            break;
                        case CLOUD:
                            chiffreAffaire =+ diffMois * 400;
                            break;
                        case SECURITE:
                            chiffreAffaire =+ diffMois * 450;
                            break;
                    }
                    return (float) chiffreAffaire;
                }

            }

        }
        return (float) chiffreAffaire;
    }

    @Transactional
    public void archiveContrat(){
        contratRepository.findContratByArchiveIsFalseAndAndDateFinContrat(new Date()).stream()
                .forEach(contrat -> contrat.setArchive(true));
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void retrieveAndUpdateStatusContrat() {
//        List<Contrat> contrats=contratRepository.findContratByArchiveIsFalse();
//        this.archiveContrat();
        etudiantRepository.findAll().stream()
                .map(Etudiant::getEquipes)
                .flatMap(List::stream)
                .forEach(equipe -> log.info(equipe.getNomEquipe()));

       /* contrats.stream().filter(contrat -> HelperClass.DiffTwoDate(new Date(),contrat.getDateFinContrat())<16)
                .forEach(contrat -> log.info("le contrat de l'etudiant"+contrat.getEtudiant().getNomE()));*/
    }


}
