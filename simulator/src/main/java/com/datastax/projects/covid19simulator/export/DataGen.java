package com.datastax.projects.covid19simulator.export;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.nosqlbench.virtdata.core.bindings.DataMapper;
import io.nosqlbench.virtdata.core.bindings.VirtData;
import io.nosqlbench.virtdata.library.basics.shared.distributions.CSVFrequencySampler;
import io.nosqlbench.virtdata.library.basics.shared.distributions.WeightedStringsFromCSV;
import io.nosqlbench.virtdata.library.basics.shared.from_long.to_boolean.ToBoolean;
import io.nosqlbench.virtdata.library.basics.shared.from_long.to_uuid.ToUUID;
import io.nosqlbench.virtdata.library.curves4.discrete.long_int.Uniform;
import io.nosqlbench.virtdata.library.realer.FirstNames;
import io.nosqlbench.virtdata.library.realer.LastNames;
import org.joda.time.DateTime;

public class DataGen {
    public static ObjectMapper mapper = new ObjectMapper();
    public static ToBoolean resultGenerator = new ToBoolean();
    //300k ms every 5 mins
    public static DataMapper<DateTime> timestampGenerator = VirtData.getMapper(
            "Mul(300000); StartingEpochMillis('2018-02-01 05:00:00');  ToDateTime()",
            DateTime.class
    );
    public static FirstNames firstNameGenerator = new FirstNames();
    public static LastNames lastNameGenerator = new LastNames();
    public static WeightedStringsFromCSV countryGenerator = new WeightedStringsFromCSV("country", "population","data/worldcities" );
    public static WeightedStringsFromCSV cityGenerator = new WeightedStringsFromCSV("city", "population","data/worldcities" );
    public static WeightedStringsFromCSV latGenerator = new WeightedStringsFromCSV("lat", "population", "data/worldcities" );
    public static WeightedStringsFromCSV lonGenerator = new WeightedStringsFromCSV("lng", "population", "data/worldcities" );
    public static Uniform age = new Uniform(21, 98);
    public static ToUUID uuidGenerator = new ToUUID();
}