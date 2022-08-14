package com.vnpt.controller;

import com.ecyrd.speed4j.StopWatch;
import com.vnpt.builder.Response;
import com.vnpt.exception.CommonException;
import com.vnpt.model.request.FindCategoryFormRequest;
import com.vnpt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> findCategory(
            @RequestParam(name = "cateId", required = false) Integer categoryId,
            @RequestParam(name = "orderType", required = false) Integer orderType,
            @RequestParam(name = "msisdn", required = false) String msisdn,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
            HttpServletRequest request
    ) {
        StopWatch stopWatch = new StopWatch();
        String requestUri = request.getRequestURI() + "?" + getRequestParams(request);
        String strResponse;
        Response serverResponse;
        try {
            FindCategoryFormRequest form = new FindCategoryFormRequest();
            form.setRequestUri(requestUri);
            form.setCategoryId(categoryId);
            form.setOrderType(orderType);
            form.setMsisdn(msisdn);
            form.setPage(page);
            form.setPageSize(pageSize);
            serverResponse = categoryService.findCategory(form);

            strResponse = gson.toJson(serverResponse, Response.class);
            requestLogger.info("CategoryController =>> findCategory finish: {} in {}", requestUri, stopWatch.stop());
        } catch (CommonException ce) {
            eLogger.error("Controller Error: {}", ce.getMessage());
            strResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ce.getMessage());
        } catch (Exception e) {
            eLogger.error("CategoryController =>> findCategory error: {}", e.getMessage());
            strResponse = buildFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ERROR_OCCURRED);
        }
        return new ResponseEntity<>(strResponse, HttpStatus.OK);
    }
}
