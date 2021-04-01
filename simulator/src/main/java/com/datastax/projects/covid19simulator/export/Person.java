package com.datastax.projects.covid19simulator.export;

import com.opencsv.bean.CsvBindByName;

import java.util.UUID;

public class Person {

    @CsvBindByName()
    private final UUID person_id;
    @CsvBindByName()
    private final String country;
    @CsvBindByName()
    private final String first_name;
    @CsvBindByName()
    private final String last_name;
    @CsvBindByName()
    private final String city;
    @CsvBindByName()
    private final String lat;
    @CsvBindByName()
    private final String lon;
    @CsvBindByName()
    private final String location;
    @CsvBindByName()
    private final int age;

    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public String getLat() {
        return lat;
    }
    public String getLon() {
        return lon;
    }
    public UUID getPerson_id() {
        return person_id;
    }

    public Person(long person_id) {
        this.person_id = DataGen.uuidGenerator.apply(person_id);
        this.first_name = DataGen.firstNameGenerator.apply(person_id);
        this.last_name = DataGen.lastNameGenerator.apply(person_id);
        this.country = DataGen.countryGenerator.apply(person_id);
        this.city = DataGen.cityGenerator.apply(person_id);
        this.lat = DataGen.latGenerator.apply(person_id);
        this.lon = DataGen.lonGenerator.apply(person_id);
        this.location = "POINT("+this.lon+" "+this.lat+")";
        this.age = DataGen.age.applyAsInt(person_id);
    }

}
