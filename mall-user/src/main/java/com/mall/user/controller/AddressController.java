package com.mall.user.controller;/**
 * Created by mic on 2019/7/31.
 */


import com.mall.show.commons.result.ResponseData;
import com.mall.show.commons.result.ResponseUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/address")
public class AddressController {


    /**
     * 获取地址列表信息
     * @return
     */
    @GetMapping("/address")
    public ResponseData address(){
        return new ResponseUtil<>().setData(null);
    }


}
