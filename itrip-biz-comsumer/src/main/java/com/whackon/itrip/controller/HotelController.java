package com.whackon.itrip.controller;

import com.whackon.itrip.base.controller.BaseController;
import com.whackon.itrip.base.enums.AreaHotEnum;
import com.whackon.itrip.base.pojo.vo.ResponseDto;
import com.whackon.itrip.pojo.entity.AreaDic;
import com.whackon.itrip.pojo.entity.LabelDic;
import com.whackon.itrip.transport.AreaDicTransport;
import com.whackon.itrip.transport.LabelDicTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 主业务酒店模块控制器
 */
@RestController("hotelController")
@RequestMapping("/biz/api/hotel")

public class
HotelController extends BaseController {
	@Autowired
		private AreaDicTransport areaDicTransport;
	@Autowired
	private LabelDicTransport labelDicTransport;
	/**
	 * 查询国内热门城市
	 * @param isChina
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/queryhotcity/{isHot}")
	//PathVariable 用来承接{isHot}
	public ResponseDto<Object> queryHotCityList(@PathVariable("isHot") Integer isChina) throws Exception{
		//创建查询对象
		AreaDic query = new AreaDic();
		//设置查询条件：是否属于国内城市
		query.setIsChina(isChina);
		//设置查询条件，是否属于热门城市
		query.setIsHot(AreaHotEnum.AREA_HOT_YES.getCode());

		//查询列表
		List<AreaDic> areaDicList = areaDicTransport.getListByQuery(query);

		return ResponseDto.success(areaDicList);
	}
	@GetMapping(value = "/queryhotelfeature")
	public ResponseDto<Object> queryHotelFeature() throws Exception {
		// 创建查询对象
		LabelDic query = new LabelDic();
		query.setParentId(16L);

		List<LabelDic> labelDicList = labelDicTransport.getListByQuery(query);

		return ResponseDto.success(labelDicList);
	}
}

