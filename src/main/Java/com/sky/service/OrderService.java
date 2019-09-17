package com.sky.service;

import com.sky.mapper.OrderMapper;
import com.sky.model.Order;
import com.sky.model.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    OrderMapper orderMapper;
    //添加
    @Transactional
    public int addOrder(Order order){
        orderMapper.addOrder(order);
        return order.getOrderId();
    }
    //删除
    @Transactional
    public Boolean deleteOrder(int orderId){
        return orderMapper.deleteOrder(orderId)>0;
    }
    //分页查询
    public Page<Order> findOrder(Page<Order> pageBean){
        pageBean.setTotalRows(orderMapper.countOrder(pageBean));
        pageBean.setDatas(orderMapper.findBypageOrder(pageBean));
        return pageBean;
    }
    //==========================================修改============================
    public Boolean updateOrder(Order order){
        return orderMapper.updateOrder(order)>0;
    }

}
