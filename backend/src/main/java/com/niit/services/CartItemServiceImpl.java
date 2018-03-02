package com.niit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartItemDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.CustomerOrder;
@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
	private CartItemDao cartItemDao;
	public void saveOrUpdateCartItem(CartItem cartItem){
		cartItemDao.saveOrUpdateCartItem(cartItem);
	}
	public void removeCartItem(int cartItemId) {
		cartItemDao.removeCartItem(cartItemId);
		
	}
	public Cart getCart(int cartId) {
		
		return cartItemDao.getCart(cartId);
	}
	public CustomerOrder createOrder(Cart cart) {
		// TODO Auto-generated method stub
		return cartItemDao.createOrder(cart);
	}
	
}