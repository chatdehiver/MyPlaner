package com.spring.plan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.service.ChallengeService;
import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeContent;
import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Member;

@Controller
public class ChallengeController {

	@Resource
	private ChallengeService challengeService;

	@RequestMapping("/addChallenge.do")
	public ModelAndView addChallenge(HttpSession session, Challenge challenge) throws Exception {

		JSONObject jsonObject = new JSONObject();

		challenge.setMemberNo(((Member) session.getAttribute("member")).getMemberNo());

		challengeService.addChallenge(challenge);
		///////////////////////////////////////// contentlist
//		challengeService.addChallengeContent(challenge, cc);
		
		jsonObject.put("challenge", challenge);
		return new ModelAndView("JsonView", "json", jsonObject);
	}

	@RequestMapping("/searchChallenge.do")
	public ModelAndView searchChallenge(HttpServletRequest request, Challenge challenge) throws Exception {
		List<Challenge> challList = new ArrayList<Challenge>();

		String challengeNo = challenge.getMemberNo() + "";
		String challengeCategory = challenge.getChallengeCategory();
		String challengeTitle = challenge.getChallengeTitle();

		challenge.setMemberNo(Integer.parseInt(challengeNo.substring(challengeNo.lastIndexOf("100") + 1)));
		challenge.setChallengeCategory(challengeCategory.substring(3));
		challenge.setChallengeTitle(challengeTitle.substring(3));
		
		if(challenge.getChallengeCategory().equals(""))
			challenge.setChallengeCategory(null);
		if(challenge.getChallengeTitle().equals(""))
			challenge.setChallengeTitle(null);
		
		System.out.println(challenge);
		challList = challengeService.searchChallengeList(challenge);
		System.out.println("contoller " + challList);
		return new ModelAndView("challenge/searchResultChallengeData", "challengeList", challList);
	}

	@RequestMapping("/detailChallenge.do")
	public ModelAndView detailChallenge(HttpServletRequest request) throws Exception {
		System.out.println("★ 디테일 챌린지 테스트 : " + request.getParameter("challengeNo"));

		int challengeNo = Integer.parseInt(request.getParameter("challengeNo"));
 		Challenge rchallenge = challengeService.getChallengeByNo(challengeNo);

		System.out.println("rchallehceTest:" + rchallenge);
		System.out.println(rchallenge.getChallengeContentList());
		return new ModelAndView("challenge/detailchallenge", "challenge", rchallenge);
	}

	@RequestMapping("/getAllChallengeList.do")
	public ModelAndView getAllChallengeList() throws Exception {
		return new ModelAndView("challenge/searchchallenge", "challengeList", challengeService.getAllChallengeList());
	}
	
	@RequestMapping("checkChallenge*.do")
	   public ModelAndView checkChallenge(String challengeNo,String challengeContent) throws Exception{
			boolean flag = false;
			String day = Daily.getDayByDate();
			ChallengeContent cc = new ChallengeContent();
			cc.setChallengeNo(Integer.parseInt(challengeNo));
			cc.setChallengeContent(challengeContent);
			cc.setChallengeContentCheck(challengeService.getChallengeContentCheck(cc));
		   
			System.out.println("controller cc ::::::::::: "+cc);
			
			int result = challengeService.checkChallengeContent(cc, day);
			if(result==1) flag = true;
			return new ModelAndView("JsonView","flag",flag);
	   }
}

