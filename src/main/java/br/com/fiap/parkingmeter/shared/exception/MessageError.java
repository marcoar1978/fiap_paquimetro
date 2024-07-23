package br.com.fiap.parkingmeter.shared.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageError {

    public LocalDateTime timestamp;

    public Integer status; // HttpStatus.NOT_FOUND.value()

    public String message;
}
