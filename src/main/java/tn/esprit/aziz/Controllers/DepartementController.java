package tn.esprit.aziz.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.aziz.Entities.Departement;
import tn.esprit.aziz.Services.IDepartementService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    IDepartementService iDepartementService;

    @GetMapping("/getall")
    List<Departement> retrieveDepartments(){
        return iDepartementService.getAllDepartement();
    }

    @PostMapping("add")
    public Departement addDepartement(@RequestBody Departement d){
        return iDepartementService.addDepartement(d);
    }

    @PutMapping("update")
    public Departement updateDepartement(@RequestBody Departement d){
        return iDepartementService.updateDepartement(d);
    }

    @GetMapping("/getone")
    public Departement retrieveDepartement(@PathVariable("id") Integer idDepartement){
        return iDepartementService.getById(idDepartement);
    }

    @DeleteMapping("/delete")
    public void deleteDepartement(@PathVariable("id") Integer idDepartement){
        iDepartementService.removeDepartement(idDepartement);
    }

    @PutMapping("/assign/{idUniversite}/{idDepartement}")
    public void addAndAssignDepartement(@PathVariable Integer idUniversite,@PathVariable Integer idDepartement) {
        iDepartementService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }
    @GetMapping("/retriveDepByUniv/{idUniversity}")
    public List<Departement> retrieveDepartementByUniversity(@PathVariable Integer idUniversity){
        return iDepartementService.retrieveDepartementsByUniversite(idUniversity);
    }


}
