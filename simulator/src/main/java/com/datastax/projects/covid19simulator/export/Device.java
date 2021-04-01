package com.datastax.projects.covid19simulator.export;

import com.opencsv.bean.CsvBindByName;

import java.time.Instant;

public class Device {

    @CsvBindByName(column = "device_id")
    private final String deviceId;

    @CsvBindByName(column = "last_sync")
    private final Instant lastSync;

    public Device(int prefix, long personId) {
        this.deviceId = PersonDevice.toDivideId(prefix, personId);
        this.lastSync = Instant.ofEpochMilli(System.currentTimeMillis());
    }

    public String getDeviceId() {
        return deviceId;
    }

    public Instant getLastSync() {
        return lastSync;
    }
}
