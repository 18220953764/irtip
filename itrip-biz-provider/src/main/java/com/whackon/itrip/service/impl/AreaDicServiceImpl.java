package com.whackon.itrip.service.impl;

import com.whackon.itrip.dao.AreaDicDao;
import com.whackon.itrip.pojo.entity.AreaDic;
import com.whackon.itrip.service.AreaDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("areaService")
@Transactional
public class AreaDicServiceImpl implements AreaDicService {
	@Autowired
	private AreaDicDao areaDicDao;
	//根据查询获得信息列表
	public List<AreaDic> getListByQuery(AreaDic query) throws Exception {
		List<AreaDic> areaDicList = areaDicDao.findListByQuery(query);

		if(areaDicList !=null){
			return areaDicList;
		}
		return new ArrayList<AreaDic>();
	}
}
