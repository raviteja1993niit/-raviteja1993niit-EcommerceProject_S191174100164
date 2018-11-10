package com.niit.dao;

import com.niit.model.CartItem;

public interface CartItemDao {

	public void addToCart(CartItem cartItem);

	public void deleteFromCart(int id);

	public void removeAllCartItem();

	public double getTotalPrice();

	public long getCount();

}
