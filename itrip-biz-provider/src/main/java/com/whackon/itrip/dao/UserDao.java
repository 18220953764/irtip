package com.whackon.itrip.dao;

import com.whackon.itrip.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>爱旅行-用户信息数据持久层接口</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface UserDao {
	List<User> findListByQuery(User query) throws Exception;
	//保存用户信息
	int saveUser(User user) throws Exception;

	//修改用户信息
	int updateUser(User user) throws Exception;
}
