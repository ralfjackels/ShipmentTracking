package com.dhl_miniprojekt.services;

import com.dhl_miniprojekt.entities.Sendung;
import com.dhl_miniprojekt.repositories.SendungsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Optional;

@Service
public class SendungsService {

    private SendungsRepository sendungsRepository;

    @Autowired
    public SendungsService(SendungsRepository sendungsRepository) {
        this.sendungsRepository = sendungsRepository;
    }

    /**
     * Prüft die Nutzereingabe. Über Thymeleaf wird absichtlich die Versandart eingegeben,
     * um die Nutzereingabe als String verarbeiten zu können.
     *
     */
    public Sendung pruefeSendung(Sendung sendung){

        Sendung gefundeneSendung = new Sendung();
        gefundeneSendung.setSendungNummer(null);

        if (sendung.getVersandArt().matches("[0-9]+")) {

            sendung.setSendungNummer(Integer.parseInt(sendung.getVersandArt()));

            // Überprüft ob die eingegebene Sendungsnummer in der Datenbank enthalten ist
            if (sendungsRepository.existsById(sendung.getSendungNummer())) {

                Optional<Sendung> optionalSendung = sendungsRepository.findById(sendung.getSendungNummer());
                gefundeneSendung = optionalSendung.get();
                formattiereDatum(gefundeneSendung);
            }
        }

    return gefundeneSendung;
    }

    /**
     * Formattiert Lieferdatum und Abgabedatum für die Anzeige auf der Html
     */
    public void formattiereDatum(Sendung gefundeneSendung) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd. MMMM yyyy");

        gefundeneSendung.setFormattiertesAbgabedatum(gefundeneSendung.getAbgabedatum().format(formatter));
        gefundeneSendung.setFormattiertesLieferdatum(gefundeneSendung.getLieferdatum().format(formatter));
    }
}
