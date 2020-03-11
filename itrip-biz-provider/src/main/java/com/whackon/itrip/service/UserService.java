package com.whackon.itrip.service;

import com.whackon.itrip.pojo.entity.User;

import java.util.List;

/**
 * <b>爱旅行-用户信息业务层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
public interface UserService {
	/**
	 * <b>根据查询对象查询用户信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<User> getListByQuery(User query) throws Exception;

	/**
	 *
	 * 保存用户信息
	 */
	boolean saveUser(User user) throws Exception;

	//通过userCode在redis中查询对应的激活码
	String getActiveCodeByUserCode(String userCode) throws Exception;

	//修改数据库用户激活状态
	boolean updateUser(User user) throws Exception;
}
