package com.vnpt.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@Getter
@Setter
public class CategoryResponse {

    @Expose
    @SerializedName("pageInfo")
    private InfoPage page;

    @Expose
    @SerializedName("data")
    private List<InfoCategory> infoCategoryList;
}
