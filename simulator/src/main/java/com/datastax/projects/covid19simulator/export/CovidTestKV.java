package com.datastax.projects.covid19simulator.export;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

public class CovidTestKV {
    private UUID test_id;
    private String payload;


    public CovidTestKV(long test_id){
        this.test_id = DataGen.uuidGenerator.apply(test_id);
        try {
            this.payload = DataGen.mapper.writeValueAsString(new CovidTest(test_id));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public UUID getTest_id() {
        return test_id;
    }

    public String getPayload() {
        return payload;
    }

    public CovidTestKV(UUID test_id, String payload) {
        this.test_id = test_id;
        this.payload = payload;
    }
}
