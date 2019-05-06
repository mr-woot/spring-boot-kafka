package com.paisabazaar.kafka.bean;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name = "producer")
@JsonAutoDetect
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@DynamicInsert(true)
@DynamicUpdate(true)
public class Producer implements Serializable {
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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedAt;

    public Producer(String buName, String type, String topic, String purpose, int retention, Long expiry) {
        this.buName = buName;
        this.type = type;
        this.topic = topic;
        this.purpose = purpose;
        this.retention = retention;
        this.expiry = expiry;
    }

    // Getters and Setters

    public Producer() {
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "=====> Producer{" +
                "producerId='" + producerId + '\'' +
                ", buName='" + buName + '\'' +
                ", type='" + type + '\'' +
                ", topic='" + topic + '\'' +
                ", purpose='" + purpose + '\'' +
                ", retention=" + retention +
                ", expiry=" + expiry +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
