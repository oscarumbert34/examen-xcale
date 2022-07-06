package xcale.examen.examen.service;

import xcale.examen.examen.model.Contact;
import xcale.examen.examen.model.Message;

import java.util.List;

public interface WhatsAppService {
    public void createGroup(List<Contact> contacts);
    public void sendMessage(Message message);
    public void simulate();

}
