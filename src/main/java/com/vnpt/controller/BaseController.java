package com.vnpt.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vnpt.builder.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

public abstract class BaseController {

    protected static final Logger requestLogger = LogManager.getLogger("RequestLog");
    protected static final Logger eLogger = LogManager.getLogger("ErrorLog");

    protected static final String ERROR_OCCURRED = "an error occurred";

    protected Gson gson;

    protected BaseController() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder
                .excludeFieldsWithoutExposeAnnotation()
                .serializeNulls()
                .create();
    }

    protected String getRequestParams(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();

        request.getParameterMap().keySet().stream().sorted().forEach(k -> {
            String v = request.getParameter(k);
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(k).append("=").append(v);
        });
        return sb.toString();
    }

    protected String buildFailureResponse(int code, String message) {
        Response failureResponse = new Response.Builder(0, code)
                .buildMessage(message)
                .build();
        return gson.toJson(failureResponse);
    }

}
