package xcale.examen.examen.service;

import xcale.examen.examen.model.Contact;
import xcale.examen.examen.model.Message;

import java.util.List;

public interface WhatsAppFacade {
    public void createGroup(String name ,List<Contact> contacts);
    public void sendMessage(Message message);
    public void simulate();

}
