package gmail.rezamoeinpe.cutemonitor.db._public.exception;

public class JobOperationException extends RuntimeException {
    public JobOperationException(String message) {
        super(message);
    }

    public JobOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
