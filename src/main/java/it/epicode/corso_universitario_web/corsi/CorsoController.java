package it.epicode.corso_universitario_web.corsi;

import it.epicode.corso_universitario_web.common.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corsi")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;


    @GetMapping
    //non ha la chiave primaria per cui GetMapping è l'annotazione.
    public List<Corso> getAll() {
        return corsoService.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //non ha bisogno della chiave primaria per cui PostMapping è l'annotazione
    public CommonResponse save(@RequestBody Corso corso) {
        return corsoService.save(corso);
    }


    @PutMapping
    //ha bisogno della chiave primaria per cui PutMapping è l'annotazione
    public Corso update(@PathVariable Long id, @RequestBody Corso corso) {
        corso.setId(id);
        return corsoService.update(corso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        corsoService.deleteById(id);
    }
}
