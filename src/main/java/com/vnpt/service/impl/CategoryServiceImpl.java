package com.vnpt.service.impl;

import com.vnpt.builder.Response;
import com.vnpt.cache.local.ResponseLocalCache;
import com.vnpt.dao.CategoryDAO;
import com.vnpt.model.request.FindCategoryFormRequest;
import com.vnpt.model.response.CategoryResponse;
import com.vnpt.model.response.InfoCategory;
import com.vnpt.model.response.InfoPage;
import com.vnpt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@Service
public class CategoryServiceImpl extends AbstractService implements CategoryService {

    @Autowired
    @Qualifier("responseLocalCache")
    private ResponseLocalCache responseLocalCache;

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Response findCategory(FindCategoryFormRequest form) throws Exception {

        /*
         * validate input data
         */

        /*
         * call cache
         * if cache has data, return to the client
         * else call dao
         */

        String key = form.getRequestUri();
        CategoryResponse result = (CategoryResponse) responseLocalCache.get(key);
        if (result == null) {
            result = new CategoryResponse();
            Integer categoryId = form.getCategoryId();
            List<InfoCategory> infoCategoryList = categoryDAO.findById(categoryId);

            int totalItem = infoCategoryList.size();
            int pageSize = form.getPageSize();
            int page = form.getPage();
            int totalPage = totalItem / pageSize;
            if (totalItem % pageSize != 0)
                totalPage++;
            InfoPage infoPage = new InfoPage(totalPage, totalItem, page, pageSize);
            result.setPage(infoPage);

            List<InfoCategory> resultList = new ArrayList<>();
            int start = (page - 1) * pageSize;
            int end = Math.min(page * pageSize, totalItem);
            for (int i = start; i < end; i++) {
                resultList.add(infoCategoryList.get(i));
            }
            result.setInfoCategoryList(resultList);

            responseLocalCache.put(key, result);
        }

        return new Response.Builder(1, HttpStatus.OK.value())
                .buildData(result)
                .build();
    }
}
