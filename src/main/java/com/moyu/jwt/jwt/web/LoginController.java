package com.moyu.jwt.jwt.web;

import javax.servlet.http.HttpServletResponse;

import com.moyu.jwt.jwt.constant.SystemConstant;
import com.moyu.jwt.jwt.entity.R;
import com.moyu.jwt.jwt.util.JwtUtils;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
	/**
	 *
	 * @param username
	 * @param password
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
    public R  login(String username, String password,HttpServletResponse
			response) {
		User user = new User(1,"123","123");

		if(user!=null){
			if(user.getPassword().equals(password)){
				//把token返回给客户端-->客户端保存至cookie-->客户端每次请求附带cookie参数
				String JWT = JwtUtils.createJWT("1", username, SystemConstant.JWT_TTL);
				return R.ok(JWT);
			}else{
				return R.error();
			}
		}else{
			return R.error();
		}
	}



}
