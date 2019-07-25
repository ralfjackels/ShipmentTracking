package com.dhl_miniprojekt;

import com.dhl_miniprojekt.entities.Kunde;
import com.dhl_miniprojekt.entities.Sendung;
import com.dhl_miniprojekt.repositories.KundeRepository;
import com.dhl_miniprojekt.repositories.SendungsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class DhlMiniprojektApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhlMiniprojektApplication.class, args);
    }

    /**
     * Automatische Erstellung und Befüllung der Datenbank über Spring.
     */
    @Autowired
    private KundeRepository kundeRepository;

    @Autowired
    private SendungsRepository sendungsRepository;


    @PostConstruct
    public void befuelleDatenbank() {

        Kunde leeKoer = new Kunde("Lee", "Kör", "Liefergasse", "1", "40213",
                "Düsseldorf", "Deutschland");

        Kunde bobFahrer = new Kunde("Bob", "Fahrer", "Große Elbstraße", "135", "22767",
                "Hamburg", "Deutschland");

        Kunde heinBloed = new Kunde("Hein", "Blöd", "Emilienstraße", "20", "01139",
                "Dresden", "Deutschland");

        Kunde annaBude = new Kunde("Anna", "Bude", "Friesenstraße", "29", "19059",
                "Schwerin", "Deutschland");

        Kunde reinerZufall = new Kunde("Reiner", "Zufall", "Fraunhoferstraße", "42", "80469",
                "München", "Deutschland");

        Kunde andiMauer = new Kunde("Andi", "Mauer", "Zülpicher Str.", "9", "50674",
                "Köln", "Deutschland");

        Sendung sendung1 = new Sendung("Standard", "Abgegeben", LocalDate.now(),
                LocalDate.now().plusYears(15).plusDays(56), leeKoer, bobFahrer);

        Sendung sendung2 = new Sendung("Express", "In Zustellung", LocalDate.now().minusDays(1),
                LocalDate.now(), heinBloed, annaBude);

        Sendung sendung3 = new Sendung("Standard", "Zugestellt", LocalDate.now().minusYears(77),
                LocalDate.now().minusYears(5), reinerZufall, andiMauer);

        kundeRepository.save(leeKoer);
        kundeRepository.save(bobFahrer);
        kundeRepository.save(heinBloed);
        kundeRepository.save(annaBude);
        kundeRepository.save(reinerZufall);
        kundeRepository.save(andiMauer);

        sendungsRepository.save(sendung1);
        sendungsRepository.save(sendung2);
        sendungsRepository.save(sendung3);
    }


}
