package xcale.examen.examen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact implements Observer{
    private String name;
    private String mobilPhone;
    @Builder.Default
    private List<Notification> notifications = new ArrayList<>();
    public String getNameOrMobilPhone(){
        return Objects.isNull(name) || name.isEmpty() ? mobilPhone : name;
    }
    @Override
    public void notify(Notification notification) {

        if(!notification.getSender().equals(this.getNameOrMobilPhone())){
            notifications.add(notification);
            System.out.println("#####"+this.getNameOrMobilPhone()+"######");
            System.out.println(notification.toString());

        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(mobilPhone, contact.mobilPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobilPhone);
    }
}
