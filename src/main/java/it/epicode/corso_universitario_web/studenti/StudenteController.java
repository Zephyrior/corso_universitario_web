package it.epicode.corso_universitario_web.studenti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studenti")
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @GetMapping
    public List<Studente> getAll() {
        return studenteService.findAll();
    }

    @GetMapping("/{id}")
    public Studente getById(@PathVariable Long id) {
        return studenteService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Studente create(@RequestBody Studente studente) {
        return studenteService.save(studente);
    }

    public Studente update(@PathVariable Long id, @RequestBody Studente studente) {
        studente.setId(id);
        return studenteService.update(studente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studenteService.deleteById(id);
    }
}
