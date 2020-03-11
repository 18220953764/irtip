package com.whackon.itrip.service;

import com.whackon.itrip.pojo.entity.LabelDic;

import java.util.List;

/**
 * <b>爱旅行-系统字典信息业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface LabelDicService {
	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<LabelDic> getListByQuery(LabelDic query) throws Exception;
}
