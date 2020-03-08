package com.mall.show.shopping.dal.persistence;


import com.mall.show.commons.tkmapper.TkMapper;
import com.mall.show.shopping.dal.entitys.PanelContent;
import com.mall.show.shopping.dal.entitys.PanelContentItem;

import java.util.List;

public interface PanelContentMapper extends TkMapper<PanelContent> {

    List<PanelContentItem> selectPanelPanelId(Integer panelId);
   }