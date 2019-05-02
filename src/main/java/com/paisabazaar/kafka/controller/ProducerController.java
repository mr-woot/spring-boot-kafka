package com.paisabazaar.kafka.controller;

import com.paisabazaar.kafka.bean.Producer;
import com.paisabazaar.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @GetMapping(value = "/producer", headers = "Accept=application/json")
    public ResponseEntity<Producer> getProducerById(@RequestParam("id") String id) {
        System.out.println("Fetching Producer with id " + id);
        Producer producer = producerService.findById(id);
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }

    @PostMapping(value = "/producer", headers = "Accept=application/json")
    public ResponseEntity<Void> createProducer(@RequestBody Producer producer, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Producer " + producer.getProducerId());
        producerService.createProducer(producer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/producer/{id}").buildAndExpand(producer.getProducerId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/producer", headers = "Accept=application/json")
    public ResponseEntity<List<Producer>> getProducer() {
        List<Producer> tasks = producerService.getProducer();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping(value = "/producer", headers = "Accept=application/json")
    public ResponseEntity<String> updateProducer(@RequestBody Producer currentProducer) {
        Producer producer = producerService.findById(currentProducer.getProducerId());
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        producerService.update(currentProducer, currentProducer.getProducerId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/producer", headers = "Accept=application/json")
    public ResponseEntity<Producer> deleteProducer(@RequestParam("id") String id) {
        Producer producer = producerService.findById(id);
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        producerService.deleteProducerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
