package com.whackon.itrip.controller;

import com.whackon.itrip.base.controller.BaseController;
import com.whackon.itrip.base.enums.UserActivatedEnum;
import com.whackon.itrip.base.enums.UserTypeEnum;
import com.whackon.itrip.base.pojo.vo.ResponseDto;
import com.whackon.itrip.pojo.entity.User;
import com.whackon.itrip.pojo.vo.UserVO;
import com.whackon.itrip.transport.UserTransport;
import com.whackon.itrip.util.MD5Util;
import com.whackon.itrip.util.RegValidationUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 爱旅行认证模块控制器
 */
@RestController("authController")
@RequestMapping("/auth/api")
public class AuthController extends BaseController {
	@Autowired
	private UserTransport userTransport;
	//用户名验证 电子邮件
	@GetMapping(value = "/ckusr")
	public ResponseDto<Object> checkUserEmail(String name) throws Exception{
	//校验格式
		if (RegValidationUtil.validateEmail(name)){
			// 校验通过之后，通过注册中心找到对应的生产者进行数据库校验
			// 封装查询对象
			User query = new User();
			query.setUserCode(name);
			// 进行查询
			List<User> userList = userTransport.getListByQuery(query);
			// 进行结果判断
			if (userList == null || userList.size() == 0) {
				// 此时用户注册时所填写的邮箱地址可用
				return ResponseDto.success();
			}
		}
		return ResponseDto.failure("该邮箱地址已被注册");
	}

	/**
	 * <b>使用电子邮件注册用户信息</b>
	 * @param userVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/doregister")
	public ResponseDto<Object> registryUser(@RequestBody UserVO userVO) throws Exception {
		User query = new User();
		query.setUserCode(userVO.getUserCode());
		//校验用户所给定的信息是否有效
		List<User> userList = userTransport.getListByQuery(query);
		// 进行结果判断
		if (userList == null || userList.size() == 0) {

			if (RegValidationUtil.validateEmail(userVO.getUserCode())
					&& userVO.getUserPassword() != null && !"".equals(userVO.getUserPassword())) {
				//对密码进行MD5加密
				userVO.setUserPassword(MD5Util.encrypt(userVO.getUserPassword()));
				// 将用户注册UserVO转换成User对象
				User user = new User();
				BeanUtils.copyProperties(userVO, user);
				//当调用该方法的时候，用户属于自主注册
				user.setUserType(UserTypeEnum.USER_TYPE_REG.getCode());
				//将激活状态设置为未激活
				user.setActivated(UserActivatedEnum.USER_ACTIVATED_NO.getCode());
				//使用传输层，远程调用生产者进行用户信息注册工作

				boolean flag = userTransport.saveUser(user);
				if (flag) {
					return ResponseDto.success();
				}

			// 此时用户注册时所填写的邮箱地址可用

		}
			return ResponseDto.failure("注册失败");
			}
		return ResponseDto.failure("123");

		}
	}


