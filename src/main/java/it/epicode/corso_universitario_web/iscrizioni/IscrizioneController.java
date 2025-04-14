package it.epicode.corso_universitario_web.iscrizioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/iscrizioni")
public class IscrizioneController {

    @Autowired
    private IscrizioneService iscrizioneService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Iscrizione save( IscrizioneRequest iscrizione) {
        return iscrizioneService.save(iscrizione);
    }

    public List<Iscrizione> findAll() { return iscrizioneService.findAll(); }
}
