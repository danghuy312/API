package com.vnpt.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoPage {

    @Expose
    @SerializedName("totalPage")
    private int totalPage;

    @Expose
    @SerializedName("totalItem")
    private int totalItem;

    @Expose
    @SerializedName("page")
    private int page;

    @Expose
    @SerializedName("pageSize")
    private int pageSize;
}
