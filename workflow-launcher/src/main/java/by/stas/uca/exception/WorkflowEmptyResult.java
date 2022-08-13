package by.stas.uca.exception;

public class WorkflowEmptyResult extends RuntimeException{
    public WorkflowEmptyResult() {
        super();
    }

    public WorkflowEmptyResult(String message) {
        super(message);
    }

    public WorkflowEmptyResult(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkflowEmptyResult(Throwable cause) {
        super(cause);
    }
}
