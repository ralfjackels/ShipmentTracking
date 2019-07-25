package com.dhl_miniprojekt;


import com.dhl_miniprojekt.entities.Sendung;
import com.dhl_miniprojekt.repositories.SendungsRepository;
import com.dhl_miniprojekt.services.SendungsService;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

/**
 * Logik in der SendungsService Klasse wird getestet.
 */
public class SendungsServiceTest {

    // Mock für simulierte Datenbankanbindung
    @Mock
    private SendungsRepository sendungsRepository;

    @InjectMocks
    private SendungsService sendungsService;

    /**
     * Dieser Test prüft das korrekte Verhalten bei Eingabe einer korrekten Sendungsnummer.
     */
    @Test
    public void pruefeSendungBeiRichtigerEingabe() {
        MockitoAnnotations.initMocks(this);

        // Testdaten vorbereiten
        Sendung sendung = new Sendung();
        sendung.setVersandArt("1");

        // Mockingverhalten definieren
        Mockito.when(sendungsRepository.existsById(Integer.valueOf(1))).thenReturn(true);

        Mockito.when(sendungsRepository.findById(1)).thenReturn(Optional.of(sendung));

        // Logik ausführen
        Sendung pruefeSendung = sendungsService.pruefeSendung(sendung);

        // Ergebnis überprüfen
        Assert.assertNotNull(pruefeSendung);
        Assert.assertNotNull(pruefeSendung.getSendungNummer());
        Assert.assertEquals(1, pruefeSendung.getSendungNummer().intValue());
    }

    /**
     * Dieser Test prüft das korrekte Verhalten bei Eingabe einer Sendungsnummer, die nicht in der Datenbank vorhanden ist.
     */
    @Test
    public void pruefeSendungBeiFalscherEingabeAlsZahl() {
        MockitoAnnotations.initMocks(this);

        // Testdaten vorbereiten
        Sendung sendung = new Sendung();
        sendung.setVersandArt("899");

        // Mockingverhalten definieren
        Mockito.when(sendungsRepository.existsById(Integer.valueOf(899))).thenReturn(false);

        // Logik ausführen
        Sendung pruefeSendung = sendungsService.pruefeSendung(sendung);

        // Ergebnis überprüfen
        Assert.assertNull(pruefeSendung.getSendungNummer());
    }

    /**
     * Dieser Test prüft das korrekte Verhalten bei  Eingabe einer falschen Sendungsnummer als Buchstaben.
     */
    @Test
    public void pruefeSendungBeiFalscherEingabeBuchstabe() {
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
