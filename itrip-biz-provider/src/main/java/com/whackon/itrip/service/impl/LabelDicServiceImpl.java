package com.whackon.itrip.service.impl;

import com.whackon.itrip.dao.LabelDicDao;
import com.whackon.itrip.pojo.entity.LabelDic;
import com.whackon.itrip.service.LabelDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>爱旅行-系统字典信息业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("labelDicService")
@Transactional
public class LabelDicServiceImpl implements LabelDicService {
	@Autowired
	private LabelDicDao labelDicDao;

	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<LabelDic> getListByQuery(LabelDic query) throws Exception {
		// 通过数据持久层查询结果
		List<LabelDic> areaDicList = labelDicDao.findListByQuery(query);

		if (areaDicList != null) {
			return areaDicList;
		}

		return new ArrayList<LabelDic>();
	}
}
