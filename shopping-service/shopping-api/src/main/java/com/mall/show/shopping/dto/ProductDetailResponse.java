package com.mall.show.shopping.dto;

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;


@Data
public class ProductDetailResponse extends AbstractResponse {
    private ProductDetailDto productDetailDto;
}
