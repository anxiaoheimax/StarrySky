package com.sky.service;

import com.sky.mapper.CartItemMapper;
import com.sky.model.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartItemService {
    @Resource
    CartItemMapper cartItemMapper;
    //====================================================添加=====================================================
    @Transactional
    public Boolean addCartItem(CartItem cartItem){
        return cartItemMapper.addCartItem(cartItem)>0;
    }
    //=========================================================删除=====================================================
    @Transactional
    public Boolean deleteCartItem(int cartId){
        return cartItemMapper.deleteCartItem(cartId)>0;
    }
    //=========================================清空================================================
    @Transactional
    public Boolean deleteByUid(int Uid){
        return cartItemMapper.deleteByUid(Uid)>0;
    }
    //=================================================修改=================================================
    @Transactional
    public Boolean updateCartItem(CartItem cartItem){
        return cartItemMapper.updateCartItem(cartItem)>0;
    }
    //===================================================查询=============================================
    public List<CartItem> findCartItem(int Uid){
         List<CartItem> cartItemList=cartItemMapper.findByUid(Uid);
         return cartItemList;
    }
    //通过Uid  和liquorId查询
    public CartItem chachong(CartItem cartItem){
        CartItem byUidlId = cartItemMapper.findByUidlId(cartItem);
        return byUidlId;
    }
}
