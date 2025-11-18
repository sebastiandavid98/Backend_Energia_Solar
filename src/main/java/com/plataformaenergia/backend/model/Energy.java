package com.plataformaenergia.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Document(collection = "energy")
public class Energy {
    @Id
    private String id;
    private String ownerId;
    private double amountKwh;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public Energy() {}

    public Energy(String ownerId, double amountKwh, LocalDateTime timestamp) {
        this.ownerId = ownerId;
        this.amountKwh = amountKwh;
        this.timestamp = timestamp;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }
    public double getAmountKwh() { return amountKwh; }
    public void setAmountKwh(double amountKwh) { this.amountKwh = amountKwh; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
