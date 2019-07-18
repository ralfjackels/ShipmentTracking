package com.dhl_miniprojekt.model;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class Sendung {

    /**
     * Default constructor
     */
    public Sendung() {
    }


    private int sendungNummer;


    private boolean standard;


    private  Adresse lieferAdresse;


    private Adresse startAdresse;


    private Lieferstatus lieferstatus;


    private LocalDateTime abgabeZeitpunkt;


    private LocalDateTime lieferZeitpunkt;




}