package by.stas.uca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class WorkflowExceptionHandler {

    private static final String VERSION = " custom";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String ERROR_CODE = "errorCode";
    private static final String ERROR_UNEXPECTED = "Unexpected error";
    private static final String WORKFLOW_EXCEPTION = "Workflow run error";

    @ExceptionHandler(WorkflowEmptyResultException.class)
    public ResponseEntity<Map<String, String>> handleWorkflowEmptyResult() {
        Map<String, String> errorResponse = new HashMap<>();
        String message = ERROR_UNEXPECTED;

        errorResponse.put(ERROR_MESSAGE, message);
        errorResponse.put(ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value() + VERSION);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException() {
        Map<String, String> errorResponse = new HashMap<>();
        String message = WORKFLOW_EXCEPTION;

        errorResponse.put(ERROR_MESSAGE, message);
        errorResponse.put(ERROR_CODE, HttpStatus.INTERNAL_SERVER_ERROR.value() + VERSION);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
