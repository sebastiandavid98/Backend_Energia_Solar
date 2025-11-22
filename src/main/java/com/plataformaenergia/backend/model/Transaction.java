package com.plataformaenergia.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;
    private String fromUserId;
    private String toUserId;
    private double amountKwh;
    private LocalDateTime timestamp;

    // Getters y setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFromUserId() { return fromUserId; }
    public void setFromUserId(String fromUserId) { this.fromUserId = fromUserId; }

    public String getToUserId() { return toUserId; }
    public void setToUserId(String toUserId) { this.toUserId = toUserId; }

    public double getAmountKwh() { return amountKwh; }
    public void setAmountKwh(double amountKwh) { this.amountKwh = amountKwh; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
