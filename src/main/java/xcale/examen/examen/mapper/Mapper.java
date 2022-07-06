package xcale.examen.examen.mapper;

import org.modelmapper.ModelMapper;
import xcale.examen.examen.dto.ContactDTO;
import xcale.examen.examen.model.Contact;
import xcale.examen.examen.model.GroupWhatsApp;
import xcale.examen.examen.model.Message;
import xcale.examen.examen.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static Notification mapToNotification(Message message, GroupWhatsApp groupWhatsApp){
            return Notification.builder().groupName(groupWhatsApp.getName())
                    .sender(message.getSender())
                    .message(message.getContent())
                    .build();
    }

    public static Contact mapToContact(ContactDTO contactDto){
        return modelMapper.map(contactDto, Contact.class);
    }

    public static List<Contact> mapToContacts(List<ContactDTO> contactsDtos){
       List<Contact> contacts = new ArrayList<>();
       contactsDtos.forEach(p -> contacts.add(mapToContact(p)));
       return contacts;
    }
}
