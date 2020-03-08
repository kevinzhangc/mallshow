package com.mall.show.shopping.dto;

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;


@Data
public class NavListResponse extends AbstractResponse {

    private List<PanelContentDto> pannelContentDtos;
}
