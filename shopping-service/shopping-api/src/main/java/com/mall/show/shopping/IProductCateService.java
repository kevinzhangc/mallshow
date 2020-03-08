package com.mall.show.shopping;


import com.mall.show.shopping.dto.AllProductCateRequest;
import com.mall.show.shopping.dto.AllProductCateResponse;

public interface IProductCateService {
    /**
     * 获取所有产品分类
     * @param request
     * @return
     */
    AllProductCateResponse getAllProductCate(AllProductCateRequest request);
}
