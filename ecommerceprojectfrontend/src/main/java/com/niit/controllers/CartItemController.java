package com.niit.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.CartItem;
import com.niit.model.Product;
import com.niit.model.User;
import com.niit.service.CartItemService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

@Controller
public class CartItemController {
	@Autowired
private CartItemService cartItemService;
	@Autowired	
private ProductService productService;
	@Autowired
private CustomerService customerService;
	@RequestMapping(value="/cart/addtocart")
	public String addToCart(HttpServletRequest req, @AuthenticationPrincipal Principal principal)
	{
		String email=principal.getName();
		int requestedQuantity=Integer.parseInt(req.getParameter("requestedQuantity"));
		int id=Integer.parseInt(req.getParameter("id"));
		Product product=productService.selectProducts(id);
		User user=customerService.getUser(email);
		CartItem cartItem=new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(requestedQuantity);
		cartItem.setUser(user);
		cartItem.setTotalprice(requestedQuantity*product.getPrice());
		cartItemService.addToCart(cartItem);
		return "redirect:/cart/getcart";
		
	}
	@RequestMapping(value="/cart/getcart")
	public String getCart(@AuthenticationPrincipal Principal principal,Model m,HttpSession session)
	{
		String email=principal.getName();
		User user=customerService.getUser(email);
		List<CartItem> cartItems=user.getCartItems();
		m.addAttribute("cartItems", cartItems);
		double totalprice=cartItemService.getTotalPrice();
		m.addAttribute("totalprice", totalprice);
		long count=cartItemService.getCount();
		session.setAttribute("count", count);
		return "cart";
		
	}
	@RequestMapping(value="/cart/removecartitem")
	public String removeCartItem(@RequestParam int id)
	{
		cartItemService.deleteFromCart(id);
		return "redirect:/cart/getcart";
		
	}
	@RequestMapping(value="/cart/removeallcartitem")
	public String removeAllCartItem()
	{
		cartItemService.removeAllCartItem();
		return "redirect:/cart/getcart";
		
	}
}
