package by.tms.featuric.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> map = new HashMap<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistsException.class)
    public String exists(RuntimeException e, Model m){
        m.addAttribute("error", e.getMessage());
        return "Exists exception";
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String indexOutOfBound(RuntimeException e, Model m){
        m.addAttribute("error", e.getMessage());
        return "Index out of bounds exception";
    }

    @ExceptionHandler(NotEnoughRightsException.class)
    public String notEnoughRights(RuntimeException e, Model m){
        m.addAttribute("error", e.getMessage());
        return "Not enough rights exception";
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound(RuntimeException e, Model m){
        m.addAttribute("error", e.getMessage());
        return "Not found exception";
    }

    @ExceptionHandler(NotValidException.class)
    public String notValid(RuntimeException e, Model m){
        m.addAttribute("error", e.getMessage());
        return "Not valid exception";
    }
}
