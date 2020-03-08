package com.mall.shopping.mallshopping.controller;


import com.mall.shopping.mallshopping.form.PageInfo;
import com.mall.shopping.mallshopping.form.PageResponse;
import com.mall.show.commons.result.ResponseData;
import com.mall.show.commons.result.ResponseUtil;
import com.mall.show.shopping.IProductService;
import com.mall.show.shopping.constants.ShoppingRetCode;
import com.mall.show.shopping.dto.*;
import com.mall.show.user.annotation.Anoymous;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/shopping")
@Api(tags = "ProductController", description = "商品控制层")
public class ProductController {

    @Reference(timeout = 3000)
    IProductService productService;

    @Anoymous
    @GetMapping("/product/{id}")
    @ApiOperation("查询商品详情")
    @ApiImplicitParam(name = "id", value = "商品ID", paramType = "path", required = true)
    public ResponseData product(@PathVariable long id){
        ProductDetailRequest request=new ProductDetailRequest();
        request.setId(id);
        ProductDetailResponse response=productService.getProductDetail(request);

        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getProductDetailDto());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    /**
     * 返回商品列表
     * @param pageInfo
     * @return
     */
    @Anoymous
    @GetMapping("/goods")
    @ApiOperation("查询商品列表")
    @ApiImplicitParam(name = "pageInfo", value = "分页信息", dataType = "PageInfo", required = true)
    public ResponseData goods(PageInfo pageInfo){
        AllProductRequest request=new AllProductRequest();
        request.setCid(pageInfo.getCid());
        request.setPage(pageInfo.getPage());
        request.setPriceGt(pageInfo.getPriceGt());
        request.setPriceLte(pageInfo.getPriceLte());
        request.setSize(pageInfo.getSize());
        request.setSort(pageInfo.getSort());
        AllProductResponse response=productService.getAllProduct(request);
        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            PageResponse pageResponse=new PageResponse();
            pageResponse.setData(response.getProductDtoList());
            pageResponse.setTotal(response.getTotal());
            return new ResponseUtil().setData(pageResponse);
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    /**
     * 返回推荐的商品
     * @return
     */
    @Anoymous
    @GetMapping("/recommend")
    @ApiOperation("查询推荐的商品")
    public ResponseData recommend(){
        RecommendResponse response=productService.getRecommendGoods();
        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getPanelContentItemDtos());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

}
