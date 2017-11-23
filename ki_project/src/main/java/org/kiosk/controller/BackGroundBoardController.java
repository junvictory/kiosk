package org.kiosk.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kiosk.domain.Com_bgImgVO;
import org.kiosk.domain.PageMaker;
import org.kiosk.domain.SearchCriteria;
import org.kiosk.domain.UserVO;
import org.kiosk.service.Com_bgImgService;
import org.kiosk.util.UploadFileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/backGroundboard/*")
public class BackGroundBoardController {

	private static final Logger logger = LoggerFactory.getLogger(BackGroundBoardController.class);

	@Inject
	private Com_bgImgService service;

	@Resource(name = "UploadFileUtils")
	private UploadFileUtils uploadFileUtils;

	@Resource(name = "uploadPath")
	private String uploadPath;

	private String img_fileName = "backGround_";
	private String[] dirPath = { "backGround" };
	// 필요에 따라 arraylist로 원하는 항목을 add 하여 array 변환하면 유동적인 path를 생성할수있다.

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model, HttpServletRequest request) throws Exception {
		
		logger.info("backGroundboard/list - GET");
		logger.info(cri.toString());
		
		cri.setPerPageNum(6);
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO) session.getAttribute("login");
		model.addAttribute("userVO", userVO);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);
	}
	
/*	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("bi_no") int bi_no, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		logger.info("backGroundboard/readPage - GET");
		model.addAttribute(service.read(bi_no));

	}*/

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGET(@ModelAttribute("cri") SearchCriteria cri) throws Exception {
		logger.info("backGroundboard/register - GET");
		logger.info("regist get ...........");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(Com_bgImgVO board, RedirectAttributes rttr, @RequestParam("imgFile") MultipartFile imgFile,
			HttpServletRequest request) throws Exception {
		logger.info("backGroundboard/register - POST");
		logger.info("regist post ...........");
		logger.info(board.toString());

		String root_path = request.getSession().getServletContext().getRealPath("/");

		String img_filenm = uploadFileUtils.uploadImageFile(root_path + uploadPath, imgFile.getOriginalFilename(),
				imgFile.getBytes(), img_fileName + (service.lastInsertID()), dirPath);
		board.setBi_img(img_filenm);
		service.regist(board);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/backGroundboard/list";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(int bi_no, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info("backGroundboard/modifyPage - GET");
		model.addAttribute(service.read(bi_no));
		logger.info(service.read(bi_no).toString());
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(Com_bgImgVO board, SearchCriteria cri, RedirectAttributes rttr,
			@RequestParam("imgFile") MultipartFile imgFile, HttpServletRequest request,
			@RequestParam("imgName") String imgName) throws Exception {
		logger.info("backGroundboard/modifyPage - POST");
		logger.info(cri.toString());
		String img_filenm;
		String root_path = request.getSession().getServletContext().getRealPath("/");

		System.out.println("경로 : " + root_path + uploadPath);
		if (imgName.equals(board.getBi_img())) {
			img_filenm = imgName;
		} else {
			uploadFileUtils.deleteFile(root_path + uploadPath, service.read(board.getBi_no()).getBi_img());

			img_filenm = uploadFileUtils.uploadImageFile(root_path + uploadPath, imgFile.getOriginalFilename(),
					imgFile.getBytes(), img_fileName + board.getBi_no(), dirPath);
		}
		board.setBi_img(img_filenm);

		service.modify(board);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		logger.info(rttr.toString());

		return "redirect:/backGroundboard/list";
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bi_no") int bi_no, SearchCriteria cri, RedirectAttributes rttr,
			HttpServletRequest request) throws Exception {
		logger.info("galleryboard/removePage - POST");

		String root_path = request.getSession().getServletContext().getRealPath("/");

		System.out.println("경로 : " + root_path + uploadPath);
		uploadFileUtils.deleteFile(root_path + uploadPath, service.read(bi_no).getBi_img());
		service.remove(bi_no);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/backGroundboard/list?page=1";
	}
}