package com.paisabazaar.kafka.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "producer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Producer {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String producerId;

    private String buName;

    private String type;

    private String topic;

    private String purpose;

    private int retention;

    private Long expiry;

    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp updatedAt;

    public Producer(String producerId, String buName, String type, String topic, String purpose, int retention, Long expiry) {
        this.producerId = producerId;
        this.buName = buName;
        this.type = type;
        this.topic = topic;
        this.purpose = purpose;
        this.retention = retention;
        this.expiry = expiry;
    }

    // Getters and Setters

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getBuName() {
        return buName;
    }

    public void setBuName(String buName) {
        this.buName = buName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getRetention() {
        return retention;
    }

    public void setRetention(int retention) {
        this.retention = retention;
    }

    public Long getExpiry() {
        return expiry;
    }

    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
