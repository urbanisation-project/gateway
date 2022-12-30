package gateway.controller;

import lombok.AllArgsConstructor;

import java.util.Date;
@AllArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String message;
}
