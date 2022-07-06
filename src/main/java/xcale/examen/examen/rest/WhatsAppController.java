package xcale.examen.examen.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xcale.examen.examen.dto.GroupDTO;
import xcale.examen.examen.mapper.Mapper;
import xcale.examen.examen.service.WhatsAppFacade;

@RestController
@RequestMapping(path = "/whatsapp")
public class WhatsAppController {

    private WhatsAppFacade whatsAppFacade;

    @Autowired
    public WhatsAppController(WhatsAppFacade whatsAppFacade){
        this.whatsAppFacade = whatsAppFacade;
    }

    @PostMapping(value = "/simulate")
    public ResponseEntity<String> simulate() {
        whatsAppFacade.simulate();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK");
    }

    @PostMapping(value = "/group",produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> create(@RequestBody @Validated GroupDTO groupDTO) {
        whatsAppFacade.createGroup(groupDTO.getName(), Mapper.mapToContacts(groupDTO.getContacts()));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("OK");
    }



}
