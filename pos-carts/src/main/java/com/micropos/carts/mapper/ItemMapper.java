package com.micropos.carts.mapper;

import com.micropos.carts.model.Item;
import com.micropos.products.dto.ItemDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    Item toItem(ItemDto itemDto);

    ItemDto toItemDto(Item item);

    List<Item> toItems(List<ItemDto> itemDtos);

    List<ItemDto> toItemDtos(List<Item> items);
}
