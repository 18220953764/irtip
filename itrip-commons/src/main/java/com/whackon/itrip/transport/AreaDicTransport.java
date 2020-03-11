package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.AreaDic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 区域字典信息传输层借口
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/area/trans")
public interface AreaDicTransport {
	/**
	 * 根据查询获得信息列表
	 * @param query
	 * @return
	 */
	@PostMapping(value = "/query")
	List<AreaDic> getListByQuery(@RequestBody AreaDic query) throws Exception;
}
