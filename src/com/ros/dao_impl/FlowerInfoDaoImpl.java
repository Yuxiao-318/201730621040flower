package com.ros.dao_impl;

import java.util.ArrayList;
import java.util.List;


import com.ros.dao.FlowerInfoDao;
import com.ros.entity.FlowerInfo;
import com.ros.entity.FlowerType;

import com.ros.util.BaseDao;
import com.ros.util.PageData;

public class FlowerInfoDaoImpl implements FlowerInfoDao {
	/*
	 * 前台展示最新上线鲜花
	 */
	@Override
	public ArrayList<FlowerInfo> getFlowerInfoByLimit() {
		// TODO Auto-generated method stub
		String sql = "	select * from flower_info order by createTime desc limit 0,5";
		ArrayList<FlowerInfo> list = (ArrayList<FlowerInfo>) BaseDao.select(sql, FlowerInfo.class);
		if (list.size() > 0) {
			return list;

		} else {
			return null;
		}
	}

	/**
	 * 展示顶级鲜花
	 * 
	 * @return
	 * @see com.ros.dao.FlowerInfoDao#getFlowerInfoByPrice()
	 */
	@Override
	public ArrayList<FlowerInfo> getFlowerInfoByPrice() {
		// TODO Auto-generated method stub
		String sql = "select * from flower_info ORDER BY  price desc limit 0,3 ";
		ArrayList<FlowerInfo> list = (ArrayList<FlowerInfo>) BaseDao.select(sql, FlowerInfo.class);
		if (list.size() > 0) {
			return list;

		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Title: queryFlowerInfoByPage
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param page
	 * @param pageSize
	 * @param keyword
	 * @return
	 * @see com.ros.dao.FlowerInfoDao#queryFlowerInfoByPage(int, int,
	 *      java.lang.String)
	 */
	@Override
	public PageData<FlowerInfo> queryFlowerInfoByPage(int page, int pageSize, String keyword, int priceStart,
			int priceEnd, int typeId1, int typeId2, String sort, String sortType) {
		// TODO Auto-generated method stub
		String sql = "";
		if ("price".equals(sort)) {
			if ("desc".equals(sortType)) {
				sql = "select flower_info.* from flower_info INNER JOIN flower_type on flower_info.typeId=flower_type.typeId  where flowerName like ? and stock >0 and (price BETWEEN ? and ?) and (flower_type.typeId BETWEEN (?) and (?) ) ORDER BY price desc";
			} else {
				sql = "select flower_info.* from flower_info INNER JOIN flower_type on flower_info.typeId=flower_type.typeId  where flowerName like ? and stock >0 and (price BETWEEN ? and ?) and (flower_type.typeId BETWEEN (?) and (?) ) ORDER BY price asc";
			}
		} else if ("createTime".equals(sortType)) {
			sql = "select flower_info.* from flower_info INNER JOIN flower_type on flower_info.typeId=flower_type.typeId  where flowerName like ? and stock >0 and (price BETWEEN ? and ?) and (flower_type.typeId BETWEEN (?) and (?) ) ORDER BY createTime desc";
		} else {
			if ("desc".equals(sortType)) {
				sql = "select flower_info.* from flower_info INNER JOIN flower_type on flower_info.typeId=flower_type.typeId  where flowerName like ? and stock >0 and (price BETWEEN ? and ?) and (flower_type.typeId BETWEEN (?) and (?) ) ORDER BY flowerName desc";
			} else {
				sql = "select flower_info.* from flower_info INNER JOIN flower_type on flower_info.typeId=flower_type.typeId  where flowerName like ? and stock >0 and (price BETWEEN ? and ?) and (flower_type.typeId BETWEEN (?) and (?) ) ORDER BY flowerName asc";
			}
		}

		PageData<FlowerInfo> pd = BaseDao.getPage(sql, page, pageSize, FlowerInfo.class, keyword, priceStart, priceEnd,
				typeId1, typeId2);
		return pd;
	}

	/*
	 * 获取所有花的类别
	 */
	@Override
	public ArrayList<FlowerType> queryFlowerType() {
		// TODO Auto-generated method stub
		String sql = "select * from flower_type";
		ArrayList<FlowerType> list = (ArrayList<FlowerType>) BaseDao.select(sql, FlowerType.class);
		if (list.size() > 0) {
			return list;
		} else {
			return null;
		}

	}

	/*
	 * 根据传进来的鲜花编号获得该鲜花的所有信息
	 */
	@Override
	public FlowerInfo getFlowerInfoById(int flowerId) {
		// TODO Auto-generated method stub
		String sql = "select * from flower_info where flowerId=?";
		ArrayList<FlowerInfo> list = (ArrayList<FlowerInfo>) BaseDao.select(sql, FlowerInfo.class, flowerId);

		return list.get(0);
	}

	/**
	 * 后台商品信息展示
	 */
	@Override
	public PageData<FlowerInfo> queryFlowerByPage(int page, int pageSize, String keywords) {
		// TODO Auto-generated method stub
		String sql = "select * from flower_info where flowerName like ?";
		PageData<FlowerInfo> pd = BaseDao.getPage(sql, page, pageSize, FlowerInfo.class, "%" + keywords + "%");
		return pd;
	}
	@Override
	public List<FlowerInfo> queryFlowerInfo() {
		// TODO Auto-generated method stub
		String sql = "select * from flower_info";
		List<FlowerInfo> list = (List<FlowerInfo>)BaseDao.select(sql, FlowerInfo.class);
		return list;
	}

	/**   
	 * 修改鲜花库存  
	 */
	@Override
	public boolean setFlowerStockByFlowerId(int flowerId,int stock) {
		// TODO Auto-generated method stub
		String sql="update flower_info set stock=? where flowerId=?";
		boolean flag=false;
		if(BaseDao.execute(sql, stock,flowerId)>0) {
			flag=true;
			
		}
		return flag;
	}
	
	/**
	 * 用于后台新品上架
	 */
	@Override
	public boolean insertFlowerInfo(FlowerInfo f) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO flower_info(flowerName,price,words,description,sPicture,bPicture,typeId,createTime,updateTime) VALUES(?,?,?,?,?,?,?,?,?)";
		return BaseDao.execute(sql, f.getFlowerName(),f.getPrice(),f.getWords(),f.getDescription(),f.getsPicture(),f.getbPicture(),f.getTypeId(),f.getCreateTime(),f.getUpdateTime())>0;
	}
	
	/**
	 * 修改鲜花的库存量（用于后台鲜花的进货）
	 * @param flowerId 鲜花的编号
	 * @param stock 要更改成的库存量
	 * return true/更改成功（进货成功） false/更改失败（进货失败）
	 */
	@Override
	public boolean updateFlowerStock(int flowerId, int stock) {
		String sql="update flower_info set stock=? where flowerId=?";
		return BaseDao.execute(sql, stock,flowerId)>0;
	}
	
	/**
	 * 用于后台修改商品
	 */
	@Override
	public boolean updateFlower(FlowerInfo f) {
		// TODO Auto-generated method stub
		String sql = "update flower_info set flowerName=?,price=?,words=?,description=?,updateTime=? where flowerId=?";
		return BaseDao.execute(sql, f.getFlowerName(),f.getPrice(),f.getWords(),f.getDescription(),f.getUpdateTime(),f.getFlowerId())>0;
	}

}
