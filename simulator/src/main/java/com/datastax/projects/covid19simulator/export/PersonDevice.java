package com.datastax.projects.covid19simulator.export;

import com.opencsv.bean.CsvBindByName;

import java.time.Instant;
import java.util.UUID;

public class PersonDevice {
    @CsvBindByName(column = "person_id")
    private final UUID personId;

    @CsvBindByName(column = "device_id")
    private final String deviceId;

    @CsvBindByName(column = "claimed_on")
    private final Instant claimedOn;


    public PersonDevice(long devicePrefix, long personId) {
        this.personId = DataGen.uuidGenerator.apply(personId);
        this.deviceId = toDivideId(devicePrefix, personId);
        this.claimedOn = Instant.ofEpochMilli(System.currentTimeMillis());
    }

    public UUID getPersonId() {
        return personId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Instant getClaimedOn() {
        return claimedOn;
    }

    public static String toDivideId(long prefix, long personId) {
        return String.format("%02d", prefix) + "#" + String.format("%09d", personId);
    }


}
