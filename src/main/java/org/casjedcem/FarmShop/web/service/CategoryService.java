package org.casjedcem.FarmShop.web.service;

import org.casjedcem.FarmShop.web.repository.CategoryRepository;
import org.casjedcem.FarmShop.web.repository.CouponRepository;
import org.casjedcem.FarmShop.web.model.Category;
import org.casjedcem.FarmShop.web.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CouponRepository couponRepository;

	public List<Category> getAllCategory()
	{
		return categoryRepository.findAll();
	}
    public void deleteCategoryById(Long id)
    {
    	List<Product> lp = productService.getAllProduct();
    	for(Product p : lp){

				System.out.println(p.getCategory().getName());
				if(p.getCategory().getName().equals(categoryRepository.getById(id).getName())){
					productService.deleteProductById(p.getId_product());
					break;
				}

		}
    	categoryRepository.deleteById(id);
    }
    public void changeCategoryName(Long id ,String name)
    {
    	Category c = new Category();
    	c = categoryRepository.findById(id).get();
    	c.setName(name);
    	categoryRepository.save(c);
    }
	
	
}
