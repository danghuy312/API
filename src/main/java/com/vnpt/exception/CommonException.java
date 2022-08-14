package com.vnpt.exception;

import lombok.Data;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@Data
public class CommonException extends Exception {

    private int code;

    public CommonException(String message, int code) {
        super(message);
        this.code = code;
    }
}
