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
@RequestMapping(value = "/producer")
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @GetMapping(value = "/{id}", headers = "Accept=application/json")
    public ResponseEntity<Producer> getProducerById(@PathVariable("id") String id) {
        System.out.println("Fetching Producer with id " + id);
        Producer producer = producerService.findById(id);
        if (producer == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(producer, HttpStatus.OK);
    }

    @PostMapping(headers = "Accept=application/json")
    public ResponseEntity<Producer> createProducer(@RequestBody Producer producer, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Producer " + producer.getProducerId());
        Producer pr = producerService.createProducer(producer);
        return new ResponseEntity<>(pr, HttpStatus.CREATED);
    }

    @GetMapping(headers = "Accept=application/json")
    public ResponseEntity<List> getProducer() {
        List<Producer> tasks = producerService.getProducer();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping(headers = "Accept=application/json")
    public ResponseEntity<String> updateProducer(@RequestBody Producer currentProducer) {
        Producer producer = producerService.findById(currentProducer.getProducerId());
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        producerService.update(currentProducer, currentProducer.getProducerId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(headers = "Accept=application/json")
    public ResponseEntity<Producer> deleteProducer(@RequestParam("id") String id) {
        Producer producer = producerService.findById(id);
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        producerService.deleteProducerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
