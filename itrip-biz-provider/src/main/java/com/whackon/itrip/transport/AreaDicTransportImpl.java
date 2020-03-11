package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.AreaDic;
import com.whackon.itrip.service.AreaDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 区域字典信息传输层借口
 */
@RestController("areaDicTransportImpl")
@RequestMapping("/area/trans")
public class AreaDicTransportImpl implements AreaDicTransport {

	@Autowired
	private AreaDicService areaDicService;
	//根据查询获得信息列表
	@PostMapping(value = "/query")
	public List<AreaDic> getListByQuery(@RequestBody AreaDic query) throws Exception{
		return areaDicService.getListByQuery(query);

	}
}
