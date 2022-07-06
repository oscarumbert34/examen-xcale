package xcale.examen.examen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xcale.examen.examen.service.WhatsAppFacade;

@Component
public class SimulateWhatsAppService implements CommandLineRunner {
    @Autowired
    private WhatsAppFacade whatsAppService;


    @Override
    public void run(String... args) throws Exception {
        whatsAppService.simulate();
    }
}
