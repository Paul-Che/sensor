package com.myproject.controller;

import com.myproject.domain.Sensor;
import com.myproject.domain.standard.BasicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myproject.service.SensorService;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class SensorController {
    
    @Autowired
    SensorService sensorService;

    @RequestMapping(value = "/sensor", method = RequestMethod.POST)
    public ResponseEntity<BasicResponse> postDataTemperatureAndHumidity(@RequestBody final Sensor receivedSensor) {
        return sensorService.addTemperatureAndHumidityToDB(receivedSensor);
    }

    @RequestMapping(value = "/{subset}", method = RequestMethod.GET)
    public List<Integer> getSensorDatas(@PathVariable("subset") final String subset) {
        return sensorService.getSensorData(subset);

    }

    //test
}
