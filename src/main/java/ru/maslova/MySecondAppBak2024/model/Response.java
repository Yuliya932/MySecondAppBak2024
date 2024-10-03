package ru.maslova.MySecondAppBak2024.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private String uid;
    private String operationUid;
    private Systems systemName;
    private String systemTime;
    private String source;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMessage;
    private long start;
}
