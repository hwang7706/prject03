package com.ptk.persistence;

import java.util.List;
import java.util.Map;

import com.ptk.domain.SellerVO;
import com.ptk.domain.ShopVO;

public interface ShopDAO {
	public void productWrite(ShopVO shop);
	public List<ShopVO> getItemTitleCat(String Category);
	public List<String> getCategory(Map<String, Object> paramMap);
	public List<ShopVO> getCategory1(Map<String,Object> paramMap);
	public List<ShopVO> getShopListMidSelect(Map<String,Object> paramMap);
	public List<ShopVO> getAllitemList(ShopVO shop);
	public List<ShopVO> getAllitemList1(Map<String,Object> hashmap);
	public void sellerUpdate(SellerVO seller);
	public List<SellerVO> getSellers(SellerVO seller);
	public List<SellerVO> getSeller(String Category);
	public List<String> getAllCategory(String itemTitleCategory);
	public List<ShopVO> getItembyuid(int uid);
	public String getItemPricebyuid(int uid);
	public int count(String seller);
}
