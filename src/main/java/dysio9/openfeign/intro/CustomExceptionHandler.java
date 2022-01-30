package dysio9.openfeign.intro;

import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NoSuchElementException.class)
  protected ResponseEntity<String> handlePatientAlreadyExistsException(
      NoSuchElementException ex) {
    log.debug("External request was not sent");
    return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
  }
}
