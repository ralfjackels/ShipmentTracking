package com.dhl_miniprojekt;


import com.dhl_miniprojekt.entities.Sendung;
import com.dhl_miniprojekt.repositories.SendungsRepository;
import com.dhl_miniprojekt.services.SendungsService;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;


/**
 * Logik in der SendungsService Klasse wird getestet.
 */
public class SendungsServiceTest {

    // Mock für simulierte Datenbankanbindung
    @Mock
    private SendungsRepository sendungsRepository;

    @InjectMocks
    private SendungsService sendungsService;

    @InjectMocks
    private Sendung sendung = new Sendung();

    /**
     * Dieser Test prüft das korrekte Verhalten bei Eingabe einer korrekten Sendungsnummer.
     */
    @Test
    public void pruefeSendungBeiRichtigerEingabe() {
        MockitoAnnotations.initMocks(this);

        // Testdaten vorbereiten
        sendung.setVersandArt("1");
        sendung.setAbgabedatum(LocalDate.now());
        sendung.setLieferdatum(LocalDate.now().plusDays(2));

        // Mockingverhalten definieren
        Mockito.when(sendungsRepository.existsById(Integer.valueOf(1))).thenReturn(true);
        Mockito.when(sendungsRepository.findById(1)).thenReturn(Optional.of(sendung));

        // Logik ausführen
        Sendung pruefeSendung = sendungsService.pruefeSendung(sendung);

        // Ergebnis überprüfen
        Assert.assertNotNull(pruefeSendung);
        Assert.assertNotNull(pruefeSendung.getSendungNummer());
        Assert.assertThat(pruefeSendung.getSendungNummer(), is(Integer.parseInt(sendung.getVersandArt())));
    }

    /**
     * Dieser Test prüft das korrekte Verhalten bei Eingabe einer Sendungsnummer, die nicht in der Datenbank vorhanden ist.
     */
    @Test
    public void pruefeSendungBeiFalscherEingabeAlsZahl() {
        MockitoAnnotations.initMocks(this);

        // Testdaten vorbereiten
        sendung.setVersandArt("899");

        // Mockingverhalten definieren
        Mockito.when(sendungsRepository.existsById(Integer.valueOf(899))).thenReturn(false);

        // Logik ausführen
        Sendung pruefeSendung = sendungsService.pruefeSendung(sendung);

        // Ergebnis überprüfen
        Assert.assertThat(pruefeSendung.getSendungNummer(), is(nullValue()));
    }

    /**
     * Dieser Test prüft das korrekte Verhalten bei  Eingabe einer falschen Sendungsnummer als Buchstaben.
     */
    @Test
    public void pruefeSendungBeiFalscherEingabeBuchstabe() {
        MockitoAnnotations.initMocks(this);

        // Testdaten vorbereiten
        sendung.setVersandArt("b");

        // Logik ausführen
        Sendung pruefeSendung = sendungsService.pruefeSendung(sendung);

        // Ergebnis überprüfen
        Assert.assertThat(pruefeSendung.getSendungNummer(), is(nullValue()));
    }

    /**
     * Dieser prüft ob das Datum richtig formattiert wurde.
     */

    
    @Test
    public void pruefeDatumsFormattierung() {
        MockitoAnnotations.initMocks(this);

        sendung.setVersandArt("1");
        sendung.setAbgabedatum(LocalDate.of(2019, 7,25));
        sendung.setLieferdatum(LocalDate.of(2019, 7,26));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd. MMMM yyyy");

        sendungsService.formattiereDatum(sendung);

        Assert.assertThat(sendung.getAbgabedatum().format(formatter), either(containsString("Donnerstag, 25. Juli 2019")).or(containsString("Thursday, 25. July 2019")));
        Assert.assertThat(sendung.getLieferdatum().format(formatter), either(containsString("Freitag, 26. Juli 2019")).or(containsString("Friday, 26. July 2019")));
    }
}
