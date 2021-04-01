package com.datastax.projects.covid19simulator.export;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;

import java.util.UUID;

public class CovidTest {
    private UUID test_id;
    private UUID person_id;
    private boolean result;
    private DateTime time_taken;
    private DateTime time_result;


    public CovidTest(long person_id) {
        this.person_id = DataGen.uuidGenerator.apply(person_id);
        this.test_id = DataGen.uuidGenerator.apply(person_id+1000);
        this.result = DataGen.resultGenerator.apply(person_id);
        this.time_taken = DataGen.timestampGenerator.get(person_id);
        this.time_result = DataGen.timestampGenerator.get(person_id+870);
    }

    public UUID getTest_id() {
        return test_id;
    }

    public void setTest_id(UUID test_id) {
        this.test_id = test_id;
    }

    public UUID getPerson_id() {
        return person_id;
    }

    public void setPerson_id(UUID person_id) {
        this.person_id = person_id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public DateTime getTime_taken() {
        return time_taken;
    }

    public void setTime_taken(DateTime time_taken) {
        this.time_taken = time_taken;
    }

    public DateTime getTime_result() {
        return time_result;
    }

    public void setTime_result(DateTime time_result) {
        this.time_result = time_result;
    }

}
