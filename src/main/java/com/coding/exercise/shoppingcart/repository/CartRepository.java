/**
 * 
 */
package com.coding.exercise.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.exercise.shoppingcart.domain.CartEntity;

/**
 * @author ruben.ortiz
 *
 */
public interface CartRepository extends JpaRepository<CartEntity, String>
{

}
