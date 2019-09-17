package com.sky.Controller;

import com.sky.model.CartItem;
import com.sky.service.CartItemService;
import com.sky.service.LiquorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

//订单项管理
@Controller
@RequestMapping("/CartItem")
public class CartItemController {

    @Resource
    CartItemService cartItemService;
    @Resource
    LiquorService liquorService;

    @ResponseBody
    @RequestMapping("/addCartItem.action")
    public String addCartitem(CartItem cartItem) {

        System.out.println("shichu   :" + cartItem);
        //查询酒品价格
        int price = liquorService.findLiquorByid(cartItem.getLiquorId()).getPrice();
        System.out.println("价格："+price);
        //通过 Uid和  liquorId进行查询
        CartItem chachong = cartItemService.chachong(cartItem);

        if (chachong == null) {
            System.out.println("没有");
            //如果没有结果，，，，直接进行添加
            //获取酒品价格

            cartItem.setTotal_price(price);
            System.out.println("修改："+cartItem+"//////"+price);
            //添加
            Boolean aBoolean = cartItemService.addCartItem(cartItem);
            if (aBoolean) {
                return "ok";
            } else {
                return "no";
            }
        } else {
            System.out.println("有");
            //如果有结果进行修改
            cartItem.setCartId(chachong.getCartId());
            cartItem.setNumber(chachong.getNumber() + cartItem.getNumber());
            cartItem.setTotal_price(chachong.getTotal_price() + cartItem.getNumber() * price);
            System.out.println("修改："+cartItem);
            Boolean aBoolean = cartItemService.updateCartItem(cartItem);
            if (aBoolean) {
                return "ok";
            } else {
                return "no";
            }


        }
    }
    /*查询*/
    @ResponseBody
    @RequestMapping("/findCartItem.action")
    public List<CartItem> findCartItem(int uid){
        System.out.println("hhhhhhhhhhhhhhh:"+uid);
        List<CartItem> cartItemList=cartItemService.findCartItem(uid);
        System.out.println("查询结果："+cartItemList);
        return cartItemList;
    }




}