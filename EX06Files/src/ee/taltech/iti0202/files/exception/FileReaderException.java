package ee.taltech.iti0202.files.exception;

public final class FileReaderException extends RuntimeException {
    public FileReaderException(String message, Throwable e) {
        super(message, e);
    }
}
