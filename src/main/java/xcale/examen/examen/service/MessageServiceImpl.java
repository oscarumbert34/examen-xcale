package xcale.examen.examen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xcale.examen.examen.model.Message;
import xcale.examen.examen.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{


    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public void save(Message message) {

        messageRepository.save(message);
    }
}
