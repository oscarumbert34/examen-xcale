package xcale.examen.examen.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xcale.examen.examen.model.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupWhatsAppServiceTest {

    private GroupWhatsAppService groupWhatsAppService;
    private List<Contact> contacts;
    private List<Message> messages;

    private GroupWhatsApp groupWhatsApp;

    @BeforeEach
    public void setUp(){
        contacts = Arrays.asList(Contact.builder().name("Oscar").mobilPhone("1123444332").build(),
                Contact.builder().name("Claudio").mobilPhone("1155874541").build(),
                Contact.builder().name("").mobilPhone("1166985474").build());

        messages = Arrays.asList(Message.builder().sender(contacts.get(0).getNameOrMobilPhone()).content("Hola").build(),
                Message.builder().sender(contacts.get(0).getNameOrMobilPhone()).content("como va?").build(),
                Message.builder().sender(contacts.get(1).getNameOrMobilPhone()).content("Hola oscar todo tranca vos??").build());

        groupWhatsApp = new GroupWhatsApp("AmigosPrueba");
        groupWhatsApp.add(contacts.get(0));
        groupWhatsApp.add(contacts.get(1));
        groupWhatsApp.add(contacts.get(2));

        groupWhatsAppService = new GroupWhatsAppServiceImpl(groupWhatsApp);
    }

    /**
     * Este test valida que solo se envie la notificacion a todos los contactos
     * excepto al que escribio el mensaje
     */
    @Test
    public void whenSendMessageOnlyReceiver(){

        groupWhatsAppService.writeMessage(messages.get(0));
        Notification notification1 = Notification.builder().sender("Oscar").message(messages.get(0).getContent()).build();

        assertThat(contacts.get(0)).extracting("notifications").asList().isEmpty();
        assertThat(contacts.get(1)).extracting("notifications").asList().containsOnly(notification1);
        assertThat(contacts.get(2)).extracting("notifications").asList().containsOnly(notification1);

    }
}
