package com.myproject.service;

import com.myproject.domain.Sensor;
import com.myproject.domain.standard.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SensorService {

    BasicResponse resp = new BasicResponse().setCode("200").setMessage("Succeed");
    HttpStatus stat = HttpStatus.OK;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ResponseEntity<BasicResponse> addTemperatureAndHumidityToDB(Sensor receivedData) {
        jdbcTemplate.update("INSERT INTO TEMPERATURES (temperature, humidity) " +
                "VALUES ("+ receivedData.getTemperature() +", "+ receivedData.getHumidity() +"),");
        return new ResponseEntity<>(resp, stat);

    }

    public List<Integer> getSensorData(String subset) {
        final List<Integer> temperatures = new ArrayList<>();
        final List<Integer> humidities = new ArrayList<>();
        final String sql = "SELECT temperature, humidity FROM TEMPERATURES";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            Sensor receivedData = new Sensor();
            receivedData.setTemperature((Integer) row.get("temperature"));
            receivedData.setHumidity((Integer) row.get("humidity"));
            temperatures.add(receivedData.getTemperature());
            humidities.add(receivedData.getHumidity());
        }
        if (subset.equals("temperature")) {
            return temperatures;
        } else {
            return humidities;
        }

    }
}
