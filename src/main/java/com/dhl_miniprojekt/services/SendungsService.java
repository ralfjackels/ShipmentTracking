package com.dhl_miniprojekt.services;

import com.dhl_miniprojekt.entities.Sendung;
import com.dhl_miniprojekt.repositories.SendungsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SendungsService {

    @Autowired
    private SendungsRepository sendungsRepository;

    /**
     * Prüft die Nutzereingabe. Über Thymeleaf wird absichtlich die Versandart eingegeben,
     * um die Nutzereingabe als String verarbeiten zu können.
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
            }
        }
        return gefundeneSendung;
    }
}
