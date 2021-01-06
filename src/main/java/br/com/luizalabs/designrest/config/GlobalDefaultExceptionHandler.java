package br.com.luizalabs.designrest.config;

import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ap.shaded.freemarker.template.utility.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    private final static String MESSAGE = "message";
    private final static String TYPE = "type";
    private final static String ERROR_DEFAULT_500 = "Erro em nossos servidores. Por favor tente novamente!";
    private final static String TYPE_ERROR = "error";
    private final static String TYPE_WARNING = "warning";


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value={MethodArgumentNotValidException.class})
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors()
                .forEach((error) -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Map<String, String>> handleValidationBadRequestExceptions(String field, String message) {
        Map<String, String> errors = new HashMap<>();
        errors.put(field, message);
        return ResponseEntity.badRequest().body(errors);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(Exception ex) {
        if(ex.getCause() instanceof JsonMappingException && ex.getCause().getCause() instanceof DateTimeParseException) {
            return handleValidationBadRequestExceptions("dataLance", "deve estar no formato dd/MM/yyyy -> Ex: 01/01/2021");
        }
        Map<String, String> errors = new HashMap<>();
        errors.put(MESSAGE, ex.getMessage());
        errors.put(TYPE, TYPE_ERROR);
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String, String> handleValidationExceptions(NoSuchElementException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put(MESSAGE, ex.getMessage());
        errors.put(TYPE, TYPE_WARNING);
        log.warn(ex.getMessage());
        return errors;
    }

}