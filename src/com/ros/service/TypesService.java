package com.ros.service;

import java.util.List;

import com.ros.entity.Types;
import com.ros.util.PageData;

/**
 * 自定义类型接口TypesService
 * @author Administrator
 *
 */
public interface TypesService {
	public PageData<Types> getTypes(int page, int pageSize, String keywords);//分页显示类型
	public boolean updateType(Types t);//更新类型
	public boolean deleteType(int typeId);//类型删除
	public boolean addType(Types t);//增加类型
	public List<Types> getType();

}
