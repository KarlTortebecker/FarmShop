package org.casjedcem.FarmShop.web.adminController;

import java.util.List;

import org.casjedcem.FarmShop.web.repository.CategoryRepository;
import org.casjedcem.FarmShop.web.repository.ClientRepository;
import org.casjedcem.FarmShop.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.casjedcem.FarmShop.web.model.Category;
import org.casjedcem.FarmShop.web.model.Product;
import org.casjedcem.FarmShop.web.service.ProductService;

@Controller
public class AdminProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/Admin")
	public String showExampleView(Model model)
	{
		List<Product> products = productService.getAllProduct();
		model.addAttribute("products", products);
		return "Admin/index";
	}
    @GetMapping("/Admin/product")
    public String showAddProduct(Model model)
    {
    	model.addAttribute("category", new Category());
    	model.addAttribute("categories", productService.getAllCategories());
    	model.addAttribute("products", productService.getAllProduct());
    	return "Admin/product";
    }
    
    @PostMapping("/Admin/addP")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("pname") String name,
    		@RequestParam("price") Double price,
    		@RequestParam("desc") String desc
    		,@RequestParam("quantity") int quantity
    		,@RequestParam("brand") String brand,
    		@RequestParam("categories") String categories)
    {
    	
    	productService.saveProductToDB(file, name, desc,quantity, price,categories);
    	return "Admin/index";
    }
    
    @GetMapping("/Admin/deleteProd/{id}")
    public String deleteProduct(@PathVariable("id") Long id)
    {
    	productService.deleteProductById(id);
    	return "Admin/index";
    }
    
    @PostMapping("/Admin/changeName")
    public String changePname(@RequestParam("id") Long id,
    		@RequestParam("newPname") String name)
    {
    	productService.chageProductName(id, name);
    	return "Admin/index";
    }
    @PostMapping("/Admin/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
    		@RequestParam("newDescription") String description)
    {
    	productService.changeProductDescription(id, description);
    	return "Admin/index";
    }
    
    @PostMapping("/Admin/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
    		@RequestParam("newPrice") Double price)
    {
    	
    	productService.changeProductPrice(id, price);
    	return "Admin/index";
    }
    @PostMapping("/Admin/changeQuantity")
    public String changeQuantity(@RequestParam("id") Long id ,
    		@RequestParam("newQuantity") int quantity)
    {
    	
    	productService.changeProductQuantity(id, quantity);
    	return "Admin/index";
    }
    
    @PostMapping("/Admin/changeDiscount")
    public String changeDiscount(@RequestParam("id") Long id ,
    		@RequestParam("newDiscount") int discount)
    {
    	
    	productService.changeProductDiscount(id, discount);
    	return "Admin/index";
    }
    
    @PostMapping("/Admin/addCategory")
    public String addCategory(@ModelAttribute Category category , Model model) {
		if (categoryRepository.findByName(category.getName())){
			productService.saveCategory(category);
		}
    	return "Admin/product";
    }

	@GetMapping("/Admin/category")
	public String showCategoriesView(Model model)
	{
		model.addAttribute("categories", productService.getAllCategories());
		return "Admin/category";
	}

	@PostMapping("/Admin/changeCategoryName")
	public String changeCname(@RequestParam("id") Long id,
							  @RequestParam("newCname") String name)
	{
		categoryService.changeCategoryName(id, name);
		return "Admin/category";
	}

	@GetMapping("/Admin/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") Long id)
	{
		categoryService.deleteCategoryById(id);
		return "Admin/category";
	}


    @PostMapping("/Admin/addPictureToP")
    public String addImageToProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("product_id") Long id ) {
    	productService.addImageToProduct(file,id);
    	return "Admin/product";
    }
    @PostMapping("/Admin/addDiscountToP")
    public String addDiscountToproduct(@RequestParam("product_id") Long id ,
    		@RequestParam("discount") int discount) {
    	productService.saveProductDiscount(id,discount);
    	return "Admin/product";
    }

	@GetMapping("/Admin/client")
	public String showClientView(Model model)
	{
		model.addAttribute("clients", clientRepository.findAll());
		return "Admin/client";
	}

	@GetMapping("/Admin/deleteClient/{id}")
	public String deleteClient(@PathVariable("id") Long id)
	{
		clientRepository.deleteById(id);
		return "Admin/category";
	}
}
