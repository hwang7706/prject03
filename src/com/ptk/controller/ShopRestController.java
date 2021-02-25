package com.ptk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptk.domain.ShopVO;
import com.ptk.persistence.ShopDAO;

@RestController
@RequestMapping("/shopList/")
public class ShopRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject
	private ShopDAO dao;
	
	@RequestMapping(value="/bottomCategory", method = RequestMethod.GET, produces="text/plain; charset=utf-8")
		public String category(@RequestParam("select")String select,@RequestParam("seller")String seller) {
		Map<String, Object>paramMap = new HashMap<String, Object>();
		paramMap.put("itemMidCategory",select);
		paramMap.put("itemTitleCategory",seller);
		
		String data;
		data = "{\"category\":[";
		List<String> list = dao.getCategory(paramMap);
		for(int i=0;i<list.size();i++) {
			if(i+1 == list.size()) {
				data += "\""+list.get(i)+"\"]}";
				break;
			}
			data += "\""+list.get(i)+"\",";
		}
		logger.info(data);
		return data;
		//의류 -> 모자 후드티 티셔츠
	}
	@RequestMapping(value = "/getShopList", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String getShopList(@RequestParam("select") String select,@RequestParam("seller")String seller,@RequestParam("nowPage")String nowPage) {
		int showPage = 5;
		
		
		  if(nowPage == null || nowPage.equals("")) { 
			  nowPage = "1"; 
			  } 
		  int nowpage = Integer.parseInt(nowPage); 
		  int firstlimitPage = (nowpage-1) * showPage;
		 
		
		Map<String,Object> paraMap = new HashMap<String, Object>();
		paraMap.put("itemMidCategory",select);
		paraMap.put("itemTitleCategory",seller);
		paraMap.put("firstlimitPage", firstlimitPage);
		paraMap.put("showPage", showPage);
		
		String data;
		data = "{\"item\":[";
		List<ShopVO> list = dao.getShopListMidSelect(paraMap);
		logger.info("===="+list.size());
		for(int i=0; i<list.size(); i++) {
			ShopVO shop = list.get(i);
			if(i+1 == list.size()) {
				data += "{\"itemName\":\""+shop.getItemName()+"\",\"itemuid\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\"}]}";
				break;
			}
			data += "{\"itemName\":\""+shop.getItemName()+"\",\"itemuid\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\"},";
		}
		logger.info(data);
		
		return data;
	}
	
	
	@RequestMapping(value="/Category", method = RequestMethod.GET, produces="text/plain; charset=utf-8")
	public String category1(@RequestParam("select")String select,@RequestParam("seller")String seller,@RequestParam("nowPage")String nowPage) {
		
		int showPage = 5;
		
		
		  if(nowPage == null || nowPage.equals("")) { 
			  nowPage = "1"; 
			  } 
		  int nowpage = Integer.parseInt(nowPage); 
		  int firstlimitPage = (nowpage-1) * showPage;
		  
		  Map<String,Object> paramMap = new HashMap<String, Object>();
			paramMap.put("itemBottomCategory",select);
			paramMap.put("itemTitleCategory",seller);
			paramMap.put("firstlimitPage",firstlimitPage);
			paramMap.put("showPage", showPage);
		  
		
	String data;
	data = "{\"Categoryitem\":[";
	List<ShopVO> list = dao.getCategory1(paramMap);
	for(int i=0;i<list.size();i++) {
		ShopVO shop = list.get(i);
		if(i+1 == list.size()) {
			data += "{\"itemName\":\""+shop.getItemName()+"\",\"itemuid\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\"}]}";
			break;
		}
		data += "{\"itemName\":\""+shop.getItemName()+"\",\"itemuid\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\"},";
	}
	logger.info(data);
	return data;
	//바텀카테불러오기
}
	@RequestMapping(value="/GetAllList",method = RequestMethod.GET, produces="text/plain; charset=utf-8")
	public String getAllList(@RequestParam("seller") String seller , @RequestParam("nowPage")String nowPage ) {
		Map<String,Object> hashmap = new HashMap<String,Object>();
		int showPage = 5;
		
		
		  if(nowPage == null || nowPage.equals("")) { 
			  nowPage = "1"; 
			  } 
		  int nowpage = Integer.parseInt(nowPage); 
		  int firstlimitPage = (nowpage-1) * showPage;
		 
		hashmap.put("seller",seller);
		 hashmap.put("firstlimitPage",firstlimitPage); 
		hashmap.put("showPage", showPage);
		int count = dao.count(seller);
		
		String data;
	
		
		data = "{\"getAll\":[";
		List<ShopVO> list = dao.getAllitemList1(hashmap);
		for(int i=0;i<list.size();i++) {
			ShopVO shop = list.get(i);
			if(i+1 == list.size()) {
				data += "{\"itemName\":\""+shop.getItemName()+"\",\"itemuid\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\",\"count\":\""+count+"\"}]}";
				break;
			}
			data += "{\"itemName\":\""+shop.getItemName()+"\",\"itemuid\":\""+shop.getItemUID()+"\",\"itemPrice\":\""+shop.getItemPrice()+"\",\"img_m\":\""+shop.getImg_m()+"\",\"count\":\""+count+"\"},";
		}
		logger.info(data);
		return data;
		//해당 타이틀의 전체불러오기
	}
	@RequestMapping(value="/getAllCategory", method = RequestMethod.GET, produces="text/plain; charset=utf-8")
	public String getAllCategory(@RequestParam("seller")String seller) {
	
	String data;
	data = "{\"AllCategory\":[";
	List<String> list = dao.getAllCategory(seller);
	
	for(int i=0;i<list.size();i++) {
		if(i+1 == list.size()) {
			data += "\""+list.get(i)+"\"]}";
			break;
		}
		data += "\""+list.get(i)+"\",";
	}
	logger.info(data);
	return data;
	//의류 -> 모자 후드티 티셔츠
}
	@RequestMapping(value="/changePrice",method=RequestMethod.GET)
	public String changePrice(@RequestParam("result")String result,@RequestParam("uid")int uid) {
		String data;
		ShopVO shop = new ShopVO();
		shop.setItemPrice(dao.getItemPricebyuid(uid));
		shop.getItemPrice();
		
		data = shop.getItemPrice();;
		
		return data;
	}
	@RequestMapping(value="/cartamount",method=RequestMethod.GET)
	public void cartamount() {
		
	}
}
