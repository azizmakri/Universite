package tn.esprit.aziz.Services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.aziz.Entities.Contrat;
import tn.esprit.aziz.Entities.Departement;
import tn.esprit.aziz.Entities.Equipe;
import tn.esprit.aziz.Entities.Etudiant;
import tn.esprit.aziz.Repositories.ContratRepository;
import tn.esprit.aziz.Repositories.DepartementRepository;
import tn.esprit.aziz.Repositories.EquipeRepository;
import tn.esprit.aziz.Repositories.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service        //cree moin une instance (bean) de cette classe
//@AllArgsConstructor
public class IEtudiantServiceImp implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    ContratRepository contratrepository;
    @Autowired
    DepartementRepository departementRepository;
    @Override
    public Etudiant addStudent(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateStudent(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getById(Integer IdEtudiant) {

        return etudiantRepository.findById(IdEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllStudent() {

        return etudiantRepository.findAll();
    }

    @Override
    public void removeStudent(Integer idEtudiant) {

        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public void addAndAssignEtudiant(int idEtudiant, int idDepartement) {
        Etudiant e=etudiantRepository.findById(idEtudiant).orElse(null);
        Departement d=departementRepository.findById(idDepartement).orElse(null);
        if (d!=null&&e!=null){
            e.setDepartement(d);
        }
        etudiantRepository.save(e);
    }

    @Transactional //commit and roll back  wnahiw beha repo.save()
    @Override
    public Etudiant AssignEtudiantToEquipeAndContrat(Etudiant e, Integer idContrat, Integer idEquipe) {

        Contrat contrat = contratrepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

        if (contrat != null && equipe != null ){
            Etudiant et= etudiantRepository.save(e);

            contrat.setEtudiant(et);
           // contratrepository.save(contrat);

            equipe.getEtudiants().add(et);
           // equipeRepository.save(equipe);//!!!! ba3d kol operation wala affectatoin naamlou repo.save() bech naamlou update lil base de donnée
           if (et.getEquipes()!=null){
               et.getEquipes().add(equipe);
           }else {
               List<Equipe> equipes=new ArrayList<Equipe>();
               equipes.add(equipe);
               et.setEquipes(equipes);
           }

            return et;
        }
        return null;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(int idDepartement) {
        /*
        Departement d=departementRepository.findById(idDepartement).orElse(null);
        if (d!=null){
            return d.getEtudiants();
        }
        return null;
        */
        return etudiantRepository.findEtudiantsByDepartementIdDepartement(idDepartement);

    }
}
