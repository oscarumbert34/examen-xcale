package xcale.examen.examen.model;

import lombok.Getter;
import lombok.Setter;
import xcale.examen.examen.mapper.Mapper;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class GroupWhatsApp {

    private String name;
    private LinkedList<Message> messages;
    private List<Observer> contacts;
    public GroupWhatsApp(String name){
        this.name = name;
        contacts = new ArrayList<>();
        messages = new LinkedList<>();
    }

    public void add(Observer o) {
        contacts.add(o);
    }

    public void remove(Observer o) {
        contacts.remove(o);
    }

}
