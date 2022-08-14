package com.vnpt.model.request;

import lombok.*;

/**
 * @author HuyDD24
 * @date 8/1/2022
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseFormRequest {

    protected String requestUri;

}
