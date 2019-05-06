package com.paisabazaar.kafka.controller;

import com.paisabazaar.kafka.bean.Producer;
import com.paisabazaar.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/producer")
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @GetMapping(headers = "Accept=application/json")
    public ResponseEntity<?> getProducer(@RequestParam(value = "id", defaultValue = "") String id) {
        if (id.equals("")) {
            List<Producer> producers = producerService.getProducer();
            return new ResponseEntity<List<Producer>>(producers, HttpStatus.OK);
        } else {
            System.out.println("Fetching Producer with id " + id);
            Producer producer = producerService.findById(id);
            if (producer == null) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(producer, HttpStatus.OK);
        }

    }

    @PostMapping(headers = "Accept=application/json")
    public ResponseEntity<Producer> createProducer(@RequestBody Producer producer) {
        System.out.println("Creating Producer " + producer.getProducerId());
        Producer pr = producerService.createProducer(producer);
        return new ResponseEntity<>(pr, HttpStatus.CREATED);
    }

    @PutMapping(headers = "Accept=application/json")
    public ResponseEntity<Producer> updateProducer(@RequestParam String id, @RequestBody Producer currentProducer) {
        Producer producer = producerService.findById(id);
        if (producer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Producer x = producerService.update(currentProducer, id);
        return new ResponseEntity<>(x, HttpStatus.OK);
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
