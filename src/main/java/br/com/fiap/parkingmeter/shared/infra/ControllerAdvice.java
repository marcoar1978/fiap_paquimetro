package br.com.fiap.parkingmeter.shared.infra;

import br.com.fiap.parkingmeter.shared.exception.MessageError;
import br.com.fiap.parkingmeter.shared.exception.ParkingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
       var erros = ex.getFieldErrors().stream().map(DadosErroValidacao::new).toList();
       return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(ParkingException.class)
    public ResponseEntity ParkingException(ParkingException ex){

        MessageError messageError = new MessageError();
        messageError.setTimestamp(LocalDateTime.now());
        messageError.setStatus(HttpStatus.BAD_REQUEST.value());
        messageError.setMessage(ex.getMessage());

        return ResponseEntity.badRequest().body(messageError);
    }

    private record DadosErroValidacao(String campo, String mensagem){
        public DadosErroValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }

    }




}
