package xcale.examen.examen.mapper;

import xcale.examen.examen.model.GroupWhatsApp;
import xcale.examen.examen.model.Message;
import xcale.examen.examen.model.Notification;

public class Mapper {

    public static Notification mapToNotification(Message message, GroupWhatsApp groupWhatsApp){
            return Notification.builder().groupName(groupWhatsApp.getName())
                    .sender(message.getSender())
                    .message(message.getContent())
                    .build();
    }
}
