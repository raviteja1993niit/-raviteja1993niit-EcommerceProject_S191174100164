package com.niit.service;

import com.niit.model.CartItem;

public interface CartItemService {
public void addToCart(CartItem cartItem);

public void deleteFromCart(int id);

public void removeAllCartItem();

public double getTotalPrice();

public long getCount();
}
