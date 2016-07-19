package com.github.vivekkothari.contact;

/**
 * @author vivek.kothari on 19/07/16.
 */
public class ContactException
        extends Exception {

    private final ErrorCode errorCode;

    public ContactException(final ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ContactException(final ErrorCode errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public enum ErrorCode {
        invalid_contact
    }
}
