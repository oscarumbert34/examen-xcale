package xcale.examen.examen.service;

import org.springframework.stereotype.Service;
import xcale.examen.examen.model.Contact;
import xcale.examen.examen.model.Message;

import java.util.List;

@Service
public interface GroupWhatsAppService {

    void create(String name, List<Contact> contacts);
    void writeMessage(Message message);

}
