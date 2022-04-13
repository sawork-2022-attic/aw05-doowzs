package com.micropos.carts.rest;

import com.micropos.carts.mapper.CartMapper;
import com.micropos.carts.model.Cart;
import com.micropos.carts.service.CartService;
import com.micropos.products.api.CartsApi;
import com.micropos.products.dto.CartDto;
import com.micropos.products.dto.CheckoutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class CartController implements CartsApi {

    private final CartMapper cartMapper;
    private final CartService cartService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public CartController(CartMapper cartMapper, CartService cartService) {
        this.cartMapper = cartMapper;
        this.cartService = cartService;
    }

    @Override
    public ResponseEntity<CartDto> getCart() {
        Cart cart = cartService.getCart();
        logger.info(cart.toString());
        return new ResponseEntity<>(cartMapper.toCartDto(cart), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CartDto> addItem(String productId, Integer amount) {
        Cart cart = cartService.addItem(productId, amount);
        return new ResponseEntity<>(cartMapper.toCartDto(cart), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CartDto> removeItem(String productId) {
        Cart cart = cartService.removeItem(productId);
        return new ResponseEntity<>(cartMapper.toCartDto(cart), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CheckoutDto> checkout() {
        CheckoutDto result = new CheckoutDto();
        result.setTotal(cartService.checkout());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
