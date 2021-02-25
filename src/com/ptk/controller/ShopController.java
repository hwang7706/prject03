package com.ptk.controller;


import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ptk.domain.SellerVO;
import com.ptk.domain.ShopVO;
import com.ptk.persistence.ShopDAO;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@Inject
	private ShopDAO dao;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public void shopListget(Model model,SellerVO seller) {
		logger.info("상품페이지다");
		model.addAttribute("seller",dao.getSellers(seller));
	}	
	@RequestMapping(value="/midcat",method=RequestMethod.GET)
	public void MidCatget(@RequestParam("itemTitleCategory")String Category,Model model,ShopVO shop,SellerVO seller) {
		
		model.addAttribute("item",dao.getItemTitleCat(Category));
		model.addAttribute("seller",dao.getSeller(Category));
		logger.info(Category+"관련 상품페이지");
	}
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public void ProductWriteGET(SellerVO seller,Model model) {
		model.addAttribute("seller",dao.getSellers(seller));
		logger.info("상품작성페이지다");
	}
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String ProductWritePOST(MultipartHttpServletRequest request,HttpSession session) throws Exception {
		MultipartFile file = request.getFile("img_m");
		String fileName="";
		if(!file.isEmpty() || file != null) {
			fileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		}
		ShopVO shop = new ShopVO();
		shop.setItemName(request.getParameter("itemName"));
		shop.setItemTitleCategory(request.getParameter("itemTitleCategory"));
		shop.setItemMidCategory(request.getParameter("itemMidCategory"));
		shop.setItemBottomCategory(request.getParameter("itemBottomCategory"));
		shop.setItemPrice(request.getParameter("itemPrice"));
		shop.setImg_m(fileName);
		dao.productWrite(shop);
		return "redirect:/shop/list";
	}
	private String uploadFile(String originalName,byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+originalName;
		
		File target = new File(uploadPath,savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	@RequestMapping(value="/itemview",method=RequestMethod.GET)
	public void getViewPage(@RequestParam("itemuid")int uid,Model model) {
		model.addAttribute("item",dao.getItembyuid(uid));
		
		logger.info("상품상세페이지입니다");
		
	}
	@RequestMapping(value="/seller",method=RequestMethod.GET)
	public void getSellerPage() {
		logger.info("셀러신청페이지입니다");
	}
	@RequestMapping(value="/seller",method = RequestMethod.POST)
	public String PostSellerPage(MultipartHttpServletRequest request)throws Exception {
		MultipartFile file = request.getFile("sellerImage");
		String fileName="";
		if(!file.isEmpty() || file != null) {
			fileName = sellerImage(file.getOriginalFilename(), file.getBytes());
		}
		SellerVO seller = new SellerVO();
		seller.setSellerName(request.getParameter("sellerName"));
		seller.setSellerEmail(request.getParameter("sellerEmail"));
		seller.setSellerDomain(request.getParameter("sellerDomain"));
		seller.setSellerImage(fileName);
		dao.sellerUpdate(seller);
		return "redirect:/shop/list";
	}
	private String sellerImage(String originalName,byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString()+"_"+originalName;
		
		File target = new File(uploadPath,savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	@RequestMapping(value="/order",method=RequestMethod.GET)
	public void getorderlist() {
		
		
	}
	
}
