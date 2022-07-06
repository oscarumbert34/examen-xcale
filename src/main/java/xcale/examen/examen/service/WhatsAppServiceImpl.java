package xcale.examen.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xcale.examen.examen.model.Contact;
import xcale.examen.examen.model.Message;

import java.util.Arrays;
import java.util.List;

@Service
public class WhatsAppServiceImpl implements WhatsAppService{

    private GroupWhatsAppService groupWhatsAppService;
    private MessageService messageService;

    @Autowired
    public WhatsAppServiceImpl(GroupWhatsAppService groupWhatsAppService, MessageService messageService){
        this.groupWhatsAppService = groupWhatsAppService;
        this.messageService = messageService;
    }


    @Override
    public void createGroup(List<Contact> contacts) {
        groupWhatsAppService.create("Amigos",contacts);
    }

    @Override
    public void sendMessage(Message message) {
        messageService.save(message);
        groupWhatsAppService.writeMessage(message);
    }

    @Override
    public void simulate() {
        List<Contact> contacts = Arrays.asList(Contact.builder().name("Oscar").mobilPhone("1123444332").build(),
                Contact.builder().name("Claudio").mobilPhone("1155874541").build(),
                Contact.builder().name("").mobilPhone("1166985474").build());

        this.createGroup(contacts);

        Message message = Message.builder().sender(contacts.get(0).getNameOrMobilPhone()).content("Hola").build();
        this.sendMessage(message);
        message = Message.builder().sender(contacts.get(0).getNameOrMobilPhone()).content("como va?").build();
        this.sendMessage(message);
        message = Message.builder().sender(contacts.get(1).getNameOrMobilPhone()).content("Hola oscar todo tranca vos??").build();
        this.sendMessage(message);
        message = Message.builder().sender(contacts.get(2).getNameOrMobilPhone()).content("Buenas todo bien vos??").build();
        this.sendMessage(message);
        message = Message.builder().sender(contacts.get(0).getNameOrMobilPhone()).content("Todo tranquilo que hacen hoy?").build();
        this.sendMessage(message);


    }


}
