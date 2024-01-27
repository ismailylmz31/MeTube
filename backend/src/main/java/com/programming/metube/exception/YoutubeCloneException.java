package main.java.com.programming.metube.exception;

public class YoutubeCloneException extends RuntimeException {
    public YoutubeCloneException(String message) {
        super(message);
    }

    public YoutubeCloneException(String message, Exception exception) {
        super(message, exception);
    }
}
