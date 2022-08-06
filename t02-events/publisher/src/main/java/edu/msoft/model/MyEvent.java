package edu.msoft.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MyEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private String message;
    private LocalDateTime timestamp;

    public MyEvent() {
    }

    public MyEvent(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
