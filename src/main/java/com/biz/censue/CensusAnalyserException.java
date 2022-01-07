package com.biz.censue;

public class CensusAnalyserException extends Exception {


    private String message;
    private ExceptionType type;

    public CensusAnalyserException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public enum ExceptionType {
        CENSUS_FILE_PROBLEM,
        INCORRECT_COUNT,
        FILE_NOT_FOUNT, DELIMITER_ERROR,HEADER_MISSING
    }

    public CensusAnalyserException(String message, ExceptionType type) {
        this.message = message;
        this.type = type;
    }

    @Override
    public String toString() {
        return "CensusAnalyserException{" +
                "message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
}
