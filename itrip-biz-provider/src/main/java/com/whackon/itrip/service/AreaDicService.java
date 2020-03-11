package com.whackon.itrip.service;


import com.whackon.itrip.pojo.entity.AreaDic;

import java.util.List;

/**
 * 区域字典查询业务
 */

public interface AreaDicService  {
	//根据查询获得信息列表
	List<AreaDic> getListByQuery(AreaDic query) throws Exception;
}
