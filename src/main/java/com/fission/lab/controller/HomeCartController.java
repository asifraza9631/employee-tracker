package com.fission.lab.controller;

import com.fission.lab.model.Cart;
import com.fission.lab.model.Comment;
import com.fission.lab.model.Item;
import com.fission.lab.model.Product;
import com.fission.lab.repository.CartRepository;
import com.fission.lab.repository.ItemRepository;
import com.fission.lab.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HomeCartController {


     @Autowired
      private CartRepository cartRepository;

       @Autowired
      private ItemRepository itemRepository;

        @Autowired
       private ProductRepository productRepository;


    @PostMapping("/cart")
    public ResponseEntity<String> saveCart(@RequestBody Cart cart) {
        for (Product product : cart.getProducts()) {
            product.setCart(cart); // set the relationship between Product and Cart
            for (Item item : product.getItems()) {
                item.setProduct(product); // set the relationship between Item and Product
            }
        }

           Cart savedCart = cartRepository.save(cart);
        if (savedCart != null) {
            return ResponseEntity.accepted().body("Successfully created cart");
        } else {
            return ResponseEntity.unprocessableEntity().body("Failed to create cart");
        }
    }


}
