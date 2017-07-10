package test.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.net.www.content.text.plain;
import test.dao.UserDao;

@Controller
public class login {
	
	private static final Logger logger = LoggerFactory.getLogger(login.class);
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@RequestMapping("/login.do")
	public String loginweb(HttpServletRequest request, HttpServletResponse response) {
		Cookie c = new Cookie("name", "zhangdianyang");
		response.addCookie(c);
		Cookie[] c1 = request.getCookies();
		for (Cookie cookie : c1) {
			System.out.println(cookie.toString());
		}
		return "/login";
	}

	@RequestMapping("/loginView.do")
	public String loginView(String username, String password, boolean isRememberMe) {
		// 创建 Token
		// password = MD5Util.MD5(password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(isRememberMe);
		// 获取当前用户，并进行登录操作
		Subject user = SecurityUtils.getSubject();
		try {
			// user.login(token);
			userDao.getUser("1");
		} catch (AuthenticationException e) {
			logger.error("", e);
			throw new LoginException(e);
		}
		return "/space";
	}

	@RequestMapping("/space/view.do")
	public String view() {
		return "/space";
	}

	@RequestMapping("/register.do")
	public String register() {
		return "/register";
	}
}
