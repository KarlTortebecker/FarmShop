package org.casjedcem.Farmshop.controller;

import org.casjedcem.Farmshop.global.GlobalData;
import org.casjedcem.Farmshop.model.Product;
import org.casjedcem.Farmshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable long id){
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String cartGet(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getCurrentPrice).sum());
        model.addAttribute("cart", GlobalData.cart);

        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove (@PathVariable int index){
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model){

        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getCurrentPrice).sum());

        return "/checkout";
    }
}
