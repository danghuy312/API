package com.vnpt.service;

import com.vnpt.builder.Response;
import com.vnpt.model.request.FindCategoryFormRequest;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

public interface CategoryService {

    Response findCategory(FindCategoryFormRequest form) throws Exception;
}
