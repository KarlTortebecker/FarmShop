package org.casjedcem.Farmshop.controller;

import org.casjedcem.Farmshop.dto.ProductDTO;
import org.casjedcem.Farmshop.model.Category;
import org.casjedcem.Farmshop.model.Producer;
import org.casjedcem.Farmshop.model.Product;
import org.casjedcem.Farmshop.service.CategoryService;
import org.casjedcem.Farmshop.service.ProducerService;
import org.casjedcem.Farmshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {

    public static String uploadDir = System.getProperty("user.dir")+"/src/main/resources/static/images/productImages/";

    //Category section

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    ProducerService producerService;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }
    @GetMapping("/admin/categories")
    public String getCategories(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model){
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryService.removeCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCategory(@PathVariable int id, Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        }else
            return "404";
    }

    //Product section
    @GetMapping("/admin/products")
    public String getProducts(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String getProductsAdd(Model model){
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String postProductAdd(@ModelAttribute("productDTO")ProductDTO productDTO,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName")String imgName) throws IOException {

        String imageUUID;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            System.out.print(fileNameAndPath);
            Files.write(fileNameAndPath, file.getBytes());

        }else {
            imageUUID = imgName;
        }
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setDescription(productDTO.getDescription());
        product.setCurrentPrice(productDTO.getCurrentPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setImageName(imageUUID);
        productService.addProduct((product));
        System.out.print("yo");

        return "redirect:/admin/products";

    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(@PathVariable Long id, Model model){
        Product product = productService.getProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId((product.getCategory().getId()));
        productDTO.setCurrentPrice(product.getCurrentPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImageName());

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productDTO", productDTO);

        return "productsAdd";
    }

    //Producer section

    @GetMapping("/admin/producers")
    public String getProducers(Model model){
        model.addAttribute("producers", producerService.getAllProducer());
        return "producers";
    }

    @GetMapping("/admin/producers/add")
    public String getProducerAdd(Model model){
        model.addAttribute("producer", new Producer());
        return "producersAdd";
    }

    @PostMapping("/admin/producers/add")
    public String postProducerAdd(@ModelAttribute("producer") Producer producer){
        producerService.addProducer(producer);
        return "redirect:/admin/producers";
    }
}
