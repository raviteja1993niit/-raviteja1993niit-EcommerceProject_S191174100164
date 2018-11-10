package com.niit.serviceimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDao;
import com.niit.model.CartItem;
import com.niit.service.CartItemService;
@Service
@Transactional
public class CartItemServiceImpl implements CartItemService{
 @Autowired
	private CartItemDao cartItemDao;
	public void addToCart(CartItem cartItem) {
		cartItemDao.addToCart(cartItem);
		
	}
	@Override
	public void deleteFromCart(int id) {
		cartItemDao.deleteFromCart(id);
		
	}
	@Override
	public void removeAllCartItem() {
		cartItemDao.removeAllCartItem();
		
	}
	@Override
	public double getTotalPrice() {
		return cartItemDao.getTotalPrice();
	}
	@Override
	public long getCount() {
		return cartItemDao.getCount();
	}

}
