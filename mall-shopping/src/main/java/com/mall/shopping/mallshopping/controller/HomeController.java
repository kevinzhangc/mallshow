package com.mall.shopping.mallshopping.controller;


import com.mall.show.commons.result.ResponseData;
import com.mall.show.commons.result.ResponseUtil;
import com.mall.show.shopping.IContentService;
import com.mall.show.shopping.IHomeService;
import com.mall.show.shopping.constants.ShoppingRetCode;
import com.mall.show.shopping.dto.HomePageResponse;
import com.mall.show.shopping.dto.NavListResponse;
import com.mall.show.user.annotation.Anoymous;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shopping")
@Api(tags = "HomeController", description = "导航控制层")
public class HomeController {

    @Reference(timeout = 60000)
    IContentService contentService;

    @Reference(timeout = 60000)
    IHomeService iHomeService;

    @Anoymous
    @GetMapping("/navigation")
    @ApiOperation("导航")
    public ResponseData navigation(){
        NavListResponse response=contentService.queryNavList();
        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getPannelContentDtos());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }

    @Anoymous
    @GetMapping("/homepage")
    @ApiOperation("主页")
    public ResponseData homepage(){
        HomePageResponse response=iHomeService.homepage();
        if(response.getCode().equals(ShoppingRetCode.SUCCESS.getCode())) {
            return new ResponseUtil().setData(response.getPanelContentItemDtos());
        }
        return new ResponseUtil().setErrorMsg(response.getMsg());
    }


}
