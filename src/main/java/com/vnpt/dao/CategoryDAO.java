package com.vnpt.dao;

import com.vnpt.model.response.InfoCategory;

import java.util.List;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

public interface CategoryDAO {

    List<InfoCategory> findById(Integer categoryId) throws Exception;
}
