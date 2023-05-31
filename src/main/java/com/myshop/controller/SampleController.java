package com.myshop.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myshop.dto.MemberDTO;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@RequestMapping("main")
	public String sample(Locale locale, Model model) {
		return "sample/main";
	}
	
	@GetMapping("get1")
	public String get1(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "sample/get1";
	}
	
	@RequestMapping(value="get2", method = RequestMethod.GET)
	public String get2(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "sample/get2";
	}
	
	@RequestMapping(value="get3", method = RequestMethod.GET)
	public String get3(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "sample/get3";
	}
	//DTO/VO에 의한 데이터 전달은 RequestMethod가 POST로만 전달해야함
	@RequestMapping(value="get4", method = RequestMethod.GET)
	public String get4(MemberDTO member, Model model) {
		model.addAttribute("id", member.getId());
		model.addAttribute("pw",  member.getPw());
		return "sample/get4";
	}
	
	@RequestMapping(value="get5", method = RequestMethod.GET)
	public String get5(@ModelAttribute("mem") MemberDTO member, Model model) {
		return "sample/get5";
	}

	@RequestMapping(value="get6/{id}/{pw}", method = RequestMethod.GET)
	public String get6(@PathVariable("id") String id, @PathVariable("pw") String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "sample/get6";
	}
	
	@RequestMapping(value="get7", method = RequestMethod.GET)
	public ModelAndView get7(@RequestParam("id") String id, @RequestParam("pw") String pw, ModelAndView mav) {
		mav.addObject("id", id);	//필드가 아닌 객체도 허용
		mav.addObject("pw", pw);
		mav.setViewName("sample/get7");
		return mav;
	}
	
	
	@PostMapping("post1")
	public String post1(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "sample/post1";
	}
	
	@RequestMapping(value="post2", method = RequestMethod.POST)
	public String post2(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "sample/post2";
	}
	
	@RequestMapping(value="post3", method = RequestMethod.POST)
	public String post3(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "sample/post3";
	}
	//DTO/VO에 의한 데이터 전달은 RequestMethod가 POST로만 전달해야함
	@RequestMapping(value="post4", method = RequestMethod.POST)
	public String post4(MemberDTO member, Model model) {
		model.addAttribute("id", member.getId());
		model.addAttribute("pw",  member.getPw());
		return "sample/post4";
	}
	
	@PostMapping(value="post5")
	public String post5(@ModelAttribute("mem") MemberDTO member, Model model) {
		return "sample/post5";
	}
	
	//주로 Get방식에서 사용하기 때문에 오류 - @PathVariable
	@RequestMapping(value="post6/{id}/{pw}", method = RequestMethod.POST)
	public String post6(@PathVariable("id") String id, @PathVariable("pw") String pw, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "sample/post6";
	}
	
	@RequestMapping(value="post7", method = RequestMethod.POST)
	public ModelAndView post7(@RequestParam("id") String id, @RequestParam("pw") String pw, ModelAndView mav) {
		mav.addObject("id", id);	//필드가 아닌 객체도 허용
		mav.addObject("pw", pw);
		mav.setViewName("sample/post7");
		return mav;
	}
	

}

