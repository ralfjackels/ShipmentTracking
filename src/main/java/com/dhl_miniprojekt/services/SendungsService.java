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

    public Sendung pruefeSendung(Sendung sendung){

        Sendung gefundeneSendung = new Sendung();
        // Falls die Sendung nicht gefunden wurde, wird die Sendungsnummer auf null gesetzt,
        // um die Thymeleaf th:if und th:unless in der html-Seite ausführen zu können.
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
