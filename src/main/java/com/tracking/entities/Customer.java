package com.tracking.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    /**
     * Spring creates an automated ID that is used here as the shipment number.
     * The following mapping is used for the database connection via MariaDB:
     * One Customer(shipper/addressee) has many shipments.
     * A Shipment always has only one recipient and one sender.
     * The intersection is therefore the CustomerID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer id;

    private String firstname;
    private String lastname;
    private String street;
    private String number;
    private String postalcode;
    private String city;
    private String country;

    // TODO
    @OneToMany(mappedBy = "addressee")
    private List<Shipment> listOfAddressee = new ArrayList<>();

    @OneToMany(mappedBy = "shipper")
    private List<Shipment> listOfShipper = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstname, String lastname, String street, String number, String postalcode, String city,
                    String country) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.number = number;
        this.postalcode = postalcode;
        this.city = city;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Shipment> getListOfAddressee() {
        return listOfAddressee;
    }

    public void setListOfAddressee(List<Shipment> listOfAddressee) {
        this.listOfAddressee = listOfAddressee;
    }

    public List<Shipment> getListOfShipper() {
        return listOfShipper;
    }

    public void setListOfShipper(List<Shipment> listOfShipper) {
        this.listOfShipper = listOfShipper;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
