package edu.msoft.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public record MyEvent(String message, LocalDateTime timestamp) implements Serializable {

}