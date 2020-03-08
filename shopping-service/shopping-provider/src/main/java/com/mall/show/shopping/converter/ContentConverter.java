package com.mall.show.shopping.converter;


import com.mall.show.shopping.dal.entitys.PanelContent;
import com.mall.show.shopping.dal.entitys.PanelContentItem;
import com.mall.show.shopping.dto.PanelContentDto;
import com.mall.show.shopping.dto.PanelContentItemDto;
import com.mall.show.shopping.dto.PanelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import java.awt.*;
import java.util.List;

/**
 *
 *
 *
 * create-date: 2019/7/23-16:37
 */
@Mapper(componentModel = "spring")
public interface ContentConverter {

    @Mappings({})
    PanelContentDto panelContent2Dto(PanelContent panelContent);

    @Mappings({})
    PanelContentDto panelContentItem2Dto(PanelContentItem panelContentItem);

    @Mappings({})
    PanelDto panen2Dto(Panel panel);

    List<PanelContentDto> panelContents2Dto(List<PanelContent> panelContents);

    List<PanelContentItemDto> panelContentItem2Dto(List<PanelContentItem> panelContentItems);

}
