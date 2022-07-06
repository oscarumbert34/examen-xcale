package xcale.examen.examen.service;

import org.springframework.stereotype.Service;
import xcale.examen.examen.mapper.Mapper;
import xcale.examen.examen.model.Contact;
import xcale.examen.examen.model.GroupWhatsApp;
import xcale.examen.examen.model.Message;
import xcale.examen.examen.model.Notification;

import java.util.List;

@Service
public class GroupWhatsAppServiceImpl implements GroupWhatsAppService {
    private GroupWhatsApp groupWhatsApp;

    public GroupWhatsAppServiceImpl(GroupWhatsApp groupWhatsApp){
        this.groupWhatsApp = groupWhatsApp;
    }
    @Override
    public void create(String name, List<Contact> contacts) {
        groupWhatsApp = new GroupWhatsApp(name);
        contacts.stream().forEach(p -> groupWhatsApp.add(p));
    }

    @Override
    public void writeMessage(Message message) {
        groupWhatsApp.getMessages().addLast(message);
        Notification notification = Mapper.mapToNotification(message, groupWhatsApp);
        groupWhatsApp.getContacts().forEach(p -> p.notify(notification));
    }


}