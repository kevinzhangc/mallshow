package com.mall.show.shopping.dal.persistence;


import com.mall.show.commons.tkmapper.TkMapper;
import com.mall.show.shopping.dal.entitys.Panel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PanelMapper extends TkMapper<Panel> {

    List<Panel> selectPanelContentById(@Param("panelId") Integer panelId);
}