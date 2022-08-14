package by.stas.uca.exception;

public class WorkflowEmptyResultException extends RuntimeException{

    public WorkflowEmptyResultException() {
        super();
    }

    public WorkflowEmptyResultException(String message) {
        super(message);
    }

    public WorkflowEmptyResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkflowEmptyResultException(Throwable cause) {
        super(cause);
    }
}
