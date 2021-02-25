package com.ptk.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ptk.domain.SellerVO;
import com.ptk.domain.ShopVO;

@Repository
public class ShopDAOCon implements ShopDAO{
	
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "org.zerock.mapper.ShopMapper";
	
	@Override
	public void productWrite(ShopVO shop) {
		sqlSession.insert(NAMESPACE+".write",shop);
	}

	@Override
	public List<ShopVO> getItemTitleCat(String Category) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".itemTitleCat",Category);
	}

	@Override
	public List<String> getCategory(Map<String, Object> paramMap) {
		return sqlSession.selectList(NAMESPACE+".getCategory",paramMap);
	}

	@Override
	public List<ShopVO> getCategory1(Map<String,Object> paramMap) {
		return sqlSession.selectList(NAMESPACE+".getCategory1",paramMap);
	}

	@Override
	public List<ShopVO> getShopListMidSelect(Map<String,Object> paramMap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getShopListMidSelect",paramMap);
	}

	@Override
	public List<ShopVO> getAllitemList(ShopVO shop) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getAllitemList",shop);
	}

	@Override
	public List<ShopVO> getAllitemList1(Map<String,Object> hashmap) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getAllitemList1",hashmap);
	}

	@Override
	public void sellerUpdate(SellerVO seller) {
		sqlSession.insert(NAMESPACE+".sellerUpdate",seller);
	}

	@Override
	public List<SellerVO> getSellers(SellerVO seller) {
		return sqlSession.selectList(NAMESPACE+".getSellers",seller);
	}

	@Override
	public List<SellerVO> getSeller(String Category) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getSeller",Category);
	}

	@Override
	public List<String> getAllCategory(String itemTitleCategory) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getAllCategory",itemTitleCategory);
	}

	@Override
	public List<ShopVO> getItembyuid(int uid) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".getItembyuid",uid);
	}

	@Override
	public String getItemPricebyuid(int uid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".getItemPrice",uid);
	}

	@Override
	public int count(String seller) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".count",seller);
	}
	


	
	
	


	
	
	
}
