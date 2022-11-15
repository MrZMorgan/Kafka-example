package com.mrzmorgan;

import java.time.LocalDateTime;

public record Message(
    String message,
    LocalDateTime created
) {
}
