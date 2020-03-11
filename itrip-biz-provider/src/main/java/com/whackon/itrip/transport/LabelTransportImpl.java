package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.LabelDic;
import com.whackon.itrip.service.LabelDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b>爱旅行-系统字典信息传输层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("labelDicTransport")
@RequestMapping("/label/trans")
public class LabelTransportImpl implements LabelDicTransport {
	@Autowired
	private LabelDicService labelDicService;

	/**
	 * <b>根据查询获得信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/query")
	public List<LabelDic> getListByQuery(@RequestBody LabelDic query) throws Exception {
		return labelDicService.getListByQuery(query);
	}
}
