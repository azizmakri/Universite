package tn.esprit.aziz.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aziz.Entities.Contrat;
import tn.esprit.aziz.Services.IContratService;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {
    @Autowired
    IContratService iContratService;

    @GetMapping("/getall")
    public List<Contrat> retrieveAllContrats(){
        return iContratService.getAllContrat();
    };

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat c){
        return iContratService.addContrat(c);
    }

    @PutMapping("/update")
    public Contrat updateContrat(@RequestBody Contrat c){
        return iContratService.updateContrat(c);
    }

    @GetMapping("/getone")
    public Contrat retrieveContrat(@PathVariable("id") Integer idContrat){
        return iContratService.getById(idContrat);
    }

    @GetMapping("/delete")
    public void removeContrat(@PathVariable("id") Integer idContrat){
        iContratService.removeContrat(idContrat);
    }

    @PutMapping("/affConET/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, @PathVariable("nomE") String nomE,@PathVariable("prenomE") String PrenomE){
        return iContratService.affectContratToEtudiant(ce,nomE,PrenomE);
    }
    @GetMapping("/nbContratsValides/{startDate}/{endDate}")
    public int nbContratsValides(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate){
        return iContratService.nbContratsValides(startDate,endDate);
    }

    @GetMapping("/chiffreaffaire/{startDate}/{endDate}")
    public float getchiffredaffaire(@PathVariable("startDate")Date startDate ,@PathVariable("endDate" )Date endDate){
        return iContratService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }
}
