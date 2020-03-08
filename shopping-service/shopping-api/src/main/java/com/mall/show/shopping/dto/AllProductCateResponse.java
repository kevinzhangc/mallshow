package com.mall.show.shopping.dto;

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;

/**
 * Created by oahnus on 2019/8/8
 * 21:46.
 */
@Data
public class AllProductCateResponse extends AbstractResponse {
    private List<ProductCateDto> productCateDtoList;
}
