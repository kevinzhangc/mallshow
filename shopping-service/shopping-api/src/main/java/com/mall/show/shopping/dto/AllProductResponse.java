package com.mall.show.shopping.dto;


import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 *
 *
 *
 * create-date: 2019/7/24-16:29
 */
@Data
public class AllProductResponse extends AbstractResponse {

    private List<ProductDto> productDtoList;

    private Long total;
}
