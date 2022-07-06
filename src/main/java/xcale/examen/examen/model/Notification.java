package xcale.examen.examen.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Notification {
    private static final String TITLE = "Llego un nuevo message de : ";

    private String groupName;
    private String sender;
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(sender, that.sender) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, message);
    }

    @Override
    public String toString() {

        return TITLE + sender +"\n"+
                message;
    }
}
