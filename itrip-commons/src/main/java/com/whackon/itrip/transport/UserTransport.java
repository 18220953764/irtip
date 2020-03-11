package com.whackon.itrip.transport;

import com.whackon.itrip.pojo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>爱旅行-用户信息传输层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "itrip-biz-provider")
@RequestMapping("/user/trans")
public interface UserTransport {
	/**
	 * <b>根据查询信息查询用户信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/list")
	List<User> getListByQuery(@RequestBody User query) throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/save")
	boolean saveUser(@RequestBody User user) throws Exception;

	/**
	 * <b>通过userCode在Redis中查询对应的激活码</b>
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/activeCode")
	String getActiveCodeByUserCode(@RequestParam String userCode) throws Exception;

	/**
	 * <b>修改用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/updateUser")
	boolean updateUser(@RequestBody User user) throws Exception;
}
