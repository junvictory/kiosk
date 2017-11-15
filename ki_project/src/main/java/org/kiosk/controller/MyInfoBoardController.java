package org.kiosk.controller;

import javax.inject.Inject;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.service.Com_bureauService;
import org.kiosk.service.Com_sectionService;
import org.kiosk.service.Com_teamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/myinfoboard/*")
public class MyInfoBoardController {

	private static final Logger logger = LoggerFactory.getLogger(MyInfoBoardController.class);

	@Inject
	private Com_sectionService service;
	@Inject
	private Com_teamService teamService;
	@Inject
	private Com_bureauService bureauService;

	@RequestMapping(value = "/passwd", method = RequestMethod.GET)
	public void passwdGET(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("myinfoboard/passwd - GET");
	}

	@RequestMapping(value = "/passwd", method = RequestMethod.POST)
	public String passwdPOST(SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info("myinfoboard/passwd - POST");
		logger.info(cri.toString());

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/myinfoboard/passwd";
	}

	@RequestMapping(value = "/section", method = RequestMethod.GET)
	public void sectionGET(@ModelAttribute("cri") SearchCriteria cri, Model model,@ModelAttribute("bcd") String bcd) throws Exception {

		logger.info("myinfoboard/section - GET ");
		model.addAttribute("bureauService",bureauService.listAll());
		model.addAttribute("bcd",service.bureauList(bcd));

	}

	@RequestMapping(value = "/section", method = RequestMethod.POST)
	public String sectionPOST(SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info("myinfoboard/section - POST ");
		logger.info(cri.toString());

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");
		
		logger.info(rttr.toString());

		return "redirect:/myinfoboard/section";
	}

	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public void teamGET(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("myinfoboard/team - GET ");
		model.addAttribute("list",teamService.listAll());
	}

	@RequestMapping(value = "/team", method = RequestMethod.POST)
	public String teamPOST(SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info("myinfoboard/team - POST ");

		teamService.listAll();
		logger.info(cri.toString());

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/myinfoboard/team";
	}

}