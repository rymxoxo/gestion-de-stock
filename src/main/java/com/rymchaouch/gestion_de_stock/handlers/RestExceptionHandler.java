package com.rymchaouch.gestion_de_stock.handlers;

import com.rymchaouch.gestion_de_stock.exceptions.EntityNotFoundException;
import com.rymchaouch.gestion_de_stock.exceptions.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// Déclaration de la classe RestExceptionHandler qui étend ResponseEntityExceptionHandler
@RestControllerAdvice


public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    // Annotation indiquant que cette méthode doit être appelée lorsqu'une EntityNotFoundException est levée
    // Déclaration de la méthode handleException qui prend en paramètres l'exception EntityNotFoundException et un objet WebRequest. Cette méthode renvoie une ResponseEntity contenant un objet ErrorDto.


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException entityNotFoundException, WebRequest webRequest) {


        // Déclaration d'une variable notFound de type HttpStatus avec la valeur "NOT_FOUND" (404).
        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        // Création d'un objet ErrorDto à l'aide d'un constructeur de type Builder. Les propriétés de cet objet sont initialisées en utilisant les méthodes code(), httpCode() et message() avec les informations extraites de l'exception EntityNotFoundException.
        final ErrorDto errorDto = ErrorDto.builder()
                .code(entityNotFoundException.getErrorCodes())
                .httpCode(notFound.value())
                .message(entityNotFoundException.getMessage())
                .build();

        // Renvoi d'une ResponseEntity contenant l'objet ErrorDto que nous avons créé et le code de statut HTTP correspondant au statut "NOT_FOUND" (404). Cela permet de renvoyer une réponse cohérente aux clients de l'API lorsqu'une EntityNotFoundException est levée.
        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException invalidEntityException, WebRequest webRequest)
    {
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorDto errorDto= ErrorDto.builder()
                .code(invalidEntityException.getErrorCodes())
                .httpCode(badRequest.value())
                .message(invalidEntityException.getMessage())
                .errors(invalidEntityException.getErrors())
                .build();
        return new ResponseEntity<>(errorDto, badRequest);

    }
}
