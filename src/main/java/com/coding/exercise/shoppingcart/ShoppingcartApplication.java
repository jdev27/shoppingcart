package com.coding.exercise.shoppingcart;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.coding.exercise.shoppingcart.dto.CartDTO;
import com.coding.exercise.shoppingcart.dto.CartItemDTO;
import com.coding.exercise.shoppingcart.dto.ItemDTO;
import com.coding.exercise.shoppingcart.service.CartService;
import com.coding.exercise.shoppingcart.service.ItemService;
import com.coding.exercise.shoppingcart.utils.CommonStringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class ShoppingcartApplication extends SpringBootServletInitializer
{

	private boolean runItemStubCreator = false;

	private boolean runCartCartItemStubCreator = false;

	public static void main(String[] args)
	{
		SpringApplication.run(ShoppingcartApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(
	        SpringApplicationBuilder application)
	{
		return application.sources(ShoppingcartApplication.class);
	}

	@Bean
	public ObjectMapper serializingObjectMapper()
	{
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}

	// Populate DB with stub
	@Bean
	CommandLineRunner runner(ItemService itemService, CartService cartService)
	{

		return args -> {
			itemStubCreator(itemService);
			cartCartItemCreator(cartService);
		};
	}

	private void cartCartItemCreator(CartService cartService)
	{
		if (runCartCartItemStubCreator)
		{
			ItemDTO item = ItemDTO.builder() //
			        .del(false) //
			        .name("stubItem") //
			        .amount(new BigDecimal("1")) //
			        .description("stubDesc") //
			        .refNo("STUBREF1") //
			        .build();

			CartItemDTO cartItem = CartItemDTO.builder() //
			        .del(false) //
			        .item(item) //
			        .quantity(2)//
			        .build();

			Set<CartItemDTO> cartItems = new HashSet<>();
			cartItems.add(cartItem);
			CartDTO dto = CartDTO.builder() //
			        .del(false) //
			        .createDate("07/04/2019") //
			        .refNo("STUB-REF07042019") //
			        .cartItems(cartItems) //
			        .build();

			System.out
			        .println(CommonStringUtils.convertObjectToJsonString(dto));
			cartService.save(dto);
		}
	}

	private void itemStubCreator(ItemService itemService)
	{
		if (runItemStubCreator)
		{
			for (int i = 1; i <= 30; i++)
			{
				itemService.save(itemCreator("Item", i));
			}
		}
	}

	private ItemDTO itemCreator(String name, int counter)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss-sss");
		String suffix = dateFormat.format(new Date());
		String amount = String.valueOf(counter * 10);
		return ItemDTO.builder() //
		        .del(false) //
		        .name(name + counter) //
		        .amount(new BigDecimal(amount)) //
		        .description("description" + counter) //
		        .refNo("STUBREF" + suffix) //
		        .build();
	}
}
