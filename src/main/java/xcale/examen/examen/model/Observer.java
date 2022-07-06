package xcale.examen.examen.model;

public interface Observer {
    /**
     * Este es el metodo en el cual todos los Contactos se enteraran que hay un nuevo mensaje
     * @param notification
     */
    void notify(Notification notification);

}
