package xcale.examen.examen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xcale.examen.examen.service.WhatsAppService;

@Component
public class SimulateWhatsAppService implements CommandLineRunner {
    @Autowired
    private WhatsAppService whatsAppService;


    @Override
    public void run(String... args) throws Exception {
        whatsAppService.simulate();
    }
}
