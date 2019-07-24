package com.dhl_miniprojekt;


import com.dhl_miniprojekt.entities.Sendung;
import com.dhl_miniprojekt.repositories.SendungsRepository;
import com.dhl_miniprojekt.services.SendungsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class SendungsServiceTest {

    @Mock
    private SendungsRepository sendungsRepository;

    @InjectMocks
    private SendungsService sendungsService;

    @Test
    public void pruefeSendungBeiRichtigerEingabe() {
        MockitoAnnotations.initMocks(this);

        // Testdaten vorbereiten
        Sendung sendung = new Sendung();
        Optional<Sendung> optionalSendung = new Optional<>();
        sendung.setVersandArt("1");

        // Mockingverhalten definieren
        Mockito.when(sendungsRepository.existsById(Integer.valueOf(1))).thenReturn(true);
        Mockito.when(sendungsRepository.findById(1)).thenReturn(optionalSendung);

        // Logik ausführen
        Sendung pruefeSendung = sendungsService.pruefeSendung(sendung);

        // Ergebnis überprüfen
        Assert.assertNotNull(pruefeSendung);
        Assert.assertNotNull(pruefeSendung.getSendungNummer());
        Assert.assertEquals(1, pruefeSendung.getSendungNummer().intValue());
    }

    @Test
    public void pruefeSendungBeiFalscherEingabe() {
        MockitoAnnotations.initMocks(this);

        // Testdaten vorbereiten
        Sendung sendung = new Sendung();
        sendung.setVersandArt("b");

        // Logik ausführen
        Sendung pruefeSendung = sendungsService.pruefeSendung(sendung);

        // Ergebnis überprüfen
        Assert.assertNull(pruefeSendung.getSendungNummer());
    }
}
