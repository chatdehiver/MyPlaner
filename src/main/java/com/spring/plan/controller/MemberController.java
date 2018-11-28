package com.spring.plan.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.service.MemberService;
import com.spring.plan.model.vo.Member;

@Controller
public class MemberController {
	
	@Resource
	MemberService memberService;
	
	@RequestMapping("kakaoLogin.do")
	public ModelAndView kakaoLogin(Member member) throws Exception{
		if(memberService.checkKakao(member)) {
			//�α��θ�
		} else {
			//���
		}
		return new ModelAndView("index");
	}
}
