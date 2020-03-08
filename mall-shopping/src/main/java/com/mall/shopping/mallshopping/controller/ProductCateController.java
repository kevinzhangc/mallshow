package com.mall.shopping.mallshopping.controller;

import com.mall.show.commons.result.ResponseData;
import com.mall.show.commons.result.ResponseUtil;
import com.mall.show.shopping.IProductCateService;
import com.mall.show.shopping.constants.ShoppingRetCode;
import com.mall.show.shopping.dto.AllProductCateRequest;
import com.mall.show.shopping.dto.AllProductCateResponse;
import com.mall.show.user.annotation.Anoymous;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by oahnus on 2019/8/8
 * 22:34.
 */
@Slf4j
@RestController
@RequestMapping("/shopping")
@Api(tags = "ProductCateController", description = "商品种类控制层")
public class ProductCateController {
    @Reference(timeout = 3000)
    IProductCateService productCateService;

    @Anoymous
    @GetMapping("/categories")
    @ApiOperation("列举所有商品种类")
    @ApiImplicitParam(name = "sort", value = "是否排序", paramType = "query")
    public ResponseData allProductCateList(@RequestParam(value = "sort", required = false, defaultValue = "1") String sort) {
        AllProductCateRequest request = new AllProductCateRequest();
        request.setSort(sort);
        AllProductCateResponse response = productCateService.getAllProductCate(request);

        if (response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getProductCateDtoList());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }
}
