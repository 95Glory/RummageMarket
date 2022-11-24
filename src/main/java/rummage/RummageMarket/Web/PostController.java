package rummage.RummageMarket.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import rummage.RummageMarket.Config.Auth.PrincipalDetails;
import rummage.RummageMarket.Handler.Ex.CustomValidationException;
import rummage.RummageMarket.Service.PostService;
import rummage.RummageMarket.Web.Dto.Post.PostUploadDto;

@RequiredArgsConstructor
@Controller
public class PostController {

	@Autowired
	PostService postService;

	@PostMapping("/post")
	public String imageUpload(PostUploadDto postUploadDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

		if (postUploadDto.getFile().isEmpty()) {
			throw new CustomValidationException("이미지는 반드시 첨부해주세요.", null);
		}

		postService.upload(postUploadDto, principalDetails);
		System.out.println("controller 호출");

		return "redirect:/user/" + principalDetails.getUser().getId();
	}
	
	@GetMapping("/post/upload")
	public String upload() {
		return "post/upload";
	}
}