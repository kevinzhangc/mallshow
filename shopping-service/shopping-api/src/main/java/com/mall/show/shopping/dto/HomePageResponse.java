package com.mall.show.shopping.dto;

import com.mall.show.commons.result.AbstractResponse;
import lombok.Data;

import java.util.List;
import java.util.Set;


@Data
public class HomePageResponse extends AbstractResponse {

    private Set<PanelDto> panelContentItemDtos;
}
