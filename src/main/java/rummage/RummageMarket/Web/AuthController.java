package rummage.RummageMarket.Web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import rummage.RummageMarket.Domain.User.User;
import rummage.RummageMarket.Web.Dto.Auth.SignupDto;

@Controller
public class AuthController {
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	@PostMapping("/auth/signup")
	public String signup(SignupDto signupDto) {
		log.info(signupDto.toString());
		User user = signupDto.toEntity();
		log.info(user.toString());
		return "auth/signin";
	}
}
