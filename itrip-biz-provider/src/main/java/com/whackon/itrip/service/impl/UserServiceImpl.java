package com.whackon.itrip.service.impl;

import com.whackon.itrip.dao.UserDao;
import com.whackon.itrip.pojo.entity.User;
import com.whackon.itrip.service.UserService;
import com.whackon.itrip.util.ActiveCodeUtil;
import com.whackon.itrip.util.MailSenderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <b>爱旅行-用户信息业务层接口实现类</b>
 * @author Arthur
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private MailSenderUtil mailSenderUtil;
	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * <b>根据查询对象查询用户信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public List<User> getListByQuery(User query) throws Exception {
		// 调用数据持久层查询列表信息
		return userDao.findListByQuery(query);
	}
	//保存用户信息
	public boolean saveUser(User user) throws Exception {
		//设定用户注册时间
		user.setCreationDate(new Date());
		//使用数据持久层保存用户信息
		int count = userDao.saveUser(user);
		if (count > 0) {
			// 产生激活码，将激活码保存到Redis中
			String activeCode = ActiveCodeUtil.createActiveCode();
			// 使用StringRedisTemplate将验证码进行保存，key为用户的email地址，value就是激活码

			redisTemplate.opsForSet().add(user.getUserCode(), activeCode);
			// 设置存储于redis中的数据存活时间
			redisTemplate.expire(user.getUserCode(), 30, TimeUnit.MINUTES);
			// 通过发送邮件，将激活码发送给用户
			return mailSenderUtil.sendActiveCodeMail(user.getUserCode(), activeCode);
		}
		return false;
	}
}
