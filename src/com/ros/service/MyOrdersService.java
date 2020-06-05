package com.ros.service;

import java.util.ArrayList;
import java.util.List;


import com.ros.entity.OrderInfo;
import com.ros.entity.OrderInfo_Re_FlowerInfo;
import com.ros.entity.Orders;
import com.ros.util.PageData;

/**
 * 自定义Service接口MyOrdersService
 * @author Administrator
 *
 */
public interface MyOrdersService {

	public PageData<Orders>  queryOrderByUserId(int userId,int page,int pageSize);//用户编号查询订单信息
	public boolean createOrder(Orders orders);//订单表的生成
	public boolean insertOrderInfo(OrderInfo orderInfo);//订单详情表的插入
	public Orders getOrderInfoByOrderId(int orderId);//根据订单编号查询订单信息
	public boolean setOrderStatus(int orderId);//支付成功之后对订单进行更改
	PageData<Orders> getOrderByPage(int page, int pageSize, String keywords);//查询所有的订单信息并进行分页、模糊查询(后台)
    List<Orders> getOrderByStatus(int status);//根据订单状态获取订单信息（后台）
    boolean updateOrder(int orderId,int orderStatus,String sendTime);//根据订单编号更改订单信息（后台，只能更新订单状态和发货时间）
    List<OrderInfo_Re_FlowerInfo> queryOrderDetailInfoByOrderId(int orderId);//根据订单编号查询订单的鲜花等详情信息
}
