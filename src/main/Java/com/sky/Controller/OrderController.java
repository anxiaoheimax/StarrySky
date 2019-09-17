package com.sky.Controller;

import com.sky.model.*;
import com.sky.service.CartItemService;
import com.sky.service.CompartmentService;
import com.sky.service.DetailsService;
import com.sky.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Order")
public class OrderController {
    @Resource
    OrderService orderService;
    @Resource
    DetailsService detailsService;
    @Resource
    CartItemService cartItemService;
    @Resource
    CompartmentService compartmentService;
    //添加
    @ResponseBody
    @RequestMapping("/addOrder.action")
    public String addOrder(@RequestBody Order order){
        order.setOrder_date(new Date());

        //==========================================================添加订单======================================
        int orderId = orderService.addOrder(order);
        //==========================================================修改餐桌状态========================


        compartmentService.reserveOrUnsubscribe(new Compartment( order.getCompId(),"2",new Date()));
        //=========================================================查询购物车项===============
        List<CartItem> cartItemList = cartItemService.findCartItem(order.getUid());
        for (CartItem cartItem:cartItemList) {
            //=====================================================添加详情==========
           /* try{}catch ()*/
            Boolean addDetails = detailsService.addDetails(new Details(orderId, cartItem.getLiquorId(), cartItem.getNumber()));
            if(!addDetails){
               new MyException("详情添加失败！");
               return "no";
            }
        }
        return "ok";
    }

    //删除
    //删除订单
    @ResponseBody
    @RequestMapping("/deleteOrder.action")
    public String deleteOrder(int orderId){
        //删除详情
        Boolean deleteDetails = detailsService.deleteDetails(orderId);
        //删除订单
        Boolean deleteOrder = orderService.deleteOrder(orderId);
        if(!(deleteDetails&deleteOrder)){
            new MyException("删除失败！");
            return "no";
        }
        return "ok";
    }
    //查询
    //分============================================页查询订单==================================
    @ResponseBody
    @RequestMapping("/findOrderByPage.action")
    public HashMap findOrderByPage(Page<Order> pageBean){

        Page<Order> findOrderByPage = orderService.findOrder(pageBean);
        System.out.println("dingdan :"+findOrderByPage);
        HashMap findByPage=new HashMap();
        findByPage.put("code",0);
        findByPage.put("msg","");
        findByPage.put("count",findOrderByPage.getTotalRows());
        findByPage.put("data",findOrderByPage.getDatas());
        return findByPage;
    }
    //=================================================通过订单id查询详情=============================================
    @ResponseBody
    @RequestMapping("/findDetails.action")
    public void findDetails(int orderId){
        detailsService.findDetails(orderId);
    }
    //=============================================修改    修改付款状态==========================================
    @ResponseBody
    @RequestMapping("/updateOrder.action")
    public String  updateOrder(@RequestBody Order order){
        Boolean updateOrder = orderService.updateOrder(order);
        if(updateOrder){
            return "ok";
        }else {
            return "no";
        }

    }
}
