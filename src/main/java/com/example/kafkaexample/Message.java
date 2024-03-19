package com.example.kafkaexample;

import java.time.LocalDateTime;

public record Message(String message,
                      LocalDateTime created) {
}
