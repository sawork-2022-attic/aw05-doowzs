package com.micropos.carts.mapper;

import com.micropos.carts.model.Cart;
import com.micropos.products.dto.CartDto;
import org.mapstruct.Mapper;

@Mapper
public interface CartMapper {

    Cart toCart(CartDto cartDto);

    CartDto toCartDto(Cart cart);

}
