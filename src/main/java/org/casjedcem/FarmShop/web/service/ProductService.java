package org.casjedcem.FarmShop.web.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;

import org.casjedcem.FarmShop.web.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import org.casjedcem.FarmShop.web.repository.CategoryRepository;
import org.casjedcem.FarmShop.web.repository.ProductRepository;
import org.casjedcem.FarmShop.web.model.Carousel;
import org.casjedcem.FarmShop.web.model.Category;
import org.casjedcem.FarmShop.web.model.Product;

import net.coobird.thumbnailator.Thumbnails;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CategoryRepository categoryRepository;

	
	public void  saveProductToDB(MultipartFile file,String name,String description,int quantity
			,Double currentPrice, String categories)
	{
		Product p = new Product();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			p.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()),400,400));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setDescription(description);
		
        p.setName(name);
        p.setCurrentPrice(currentPrice);
        p.setQuantity(quantity);
        Coupon c = new Coupon();
        c.setDiscount(0);
        p.setDiscount(c);
        productRepo.save(p);
	}

	public List<Product> getAllProduct()
	{
		return productRepo.findAll();
	}
    public void deleteProductById(Long id)
    {
    	productRepo.deleteById(id);
    }
    public void chageProductName(Long id ,String name)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setName(name);
    	productRepo.save(p);    
    }
    public void changeProductDescription(Long id , String description)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setDescription(description);
    	productRepo.save(p);
    }
    public void changeProductPrice(Long id,Double price)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setCurrentPrice(price);
    	productRepo.save(p);
    }
    
    public Category saveCategory(Category category) {
    	 return categoryRepository.save(category);
    }
	public List<Category> getAllCategories() {
		
		return categoryRepository.findAll();
	}
	public void addImageToProduct(MultipartFile file, Long id) {
		
       Product p = productRepo.findById(id).get();
       Carousel carousel = new Carousel();
       String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a valid file");
		}
		try {
			carousel.setImage(resizeImageForUse(Base64.getEncoder().encodeToString(file.getBytes()),400,400));
		} catch (IOException e) {
			e.printStackTrace();
		}
         p.getCarousel().add(carousel);
         productRepo.save(p);
       
	}
	public void changeProductQuantity(Long id, int quantity) {
		Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setQuantity(quantity);
    	productRepo.save(p);
		
	}
	public void saveProductDiscount(Long id, int discount) {
		Product p = new Product();
    	p = productRepo.findById(id).get();
    	if(p.getDiscount() == null) {
    		Coupon c = new Coupon();
        	c.setDiscount(discount);
        	p.setDiscount(c);
    	}
    	
    	else {
    		p.getDiscount().setDiscount(discount);
    	}
    	productRepo.save(p);
		
	}
	public void changeProductDiscount(Long id, int discount) {
		Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.getDiscount().setDiscount(discount);
    	productRepo.save(p);
		
	}
	
	// No API
	public String resizeImageForUse(String src,int width, int height) {
		BufferedImage image = base64ToBufferedImage(src);
		try {
			image = resizeImage(image, width,height);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return bufferedImageTobase64(image);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private  BufferedImage resizeImage(BufferedImage image , int width , int height) throws IOException {
		ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
		try {
			Thumbnails.of(image).size(width, height).outputFormat("JPEG").outputQuality(1).toOutputStream(outputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] data = outputstream.toByteArray();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
		return ImageIO.read(inputStream);
	}
	private BufferedImage base64ToBufferedImage(String base64Img) {
		BufferedImage image = null;
		byte[] decodedBytes = Base64.getDecoder().decode(base64Img);
		
		try {
			image = ImageIO.read(new ByteArrayInputStream(decodedBytes));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
	private String bufferedImageTobase64(BufferedImage image ) throws UnsupportedEncodingException {
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(image, "JPEG", Base64.getEncoder().wrap(out));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out.toString(StandardCharsets.ISO_8859_1.name());
	}
	public Product getProductById(Long id) {
		
		return productRepo.findById(id).get();
	}
	public List<Product> searchProductByNameLike(String value) {
		
		return productRepo.findByNameContainingIgnoreCase(value);
	}
	

	/*public Product getProductWithBigestDiscount() {
		Coupon discount = couponRepository.findMax();
		List<Product> products = productRepo.findAll();
		Product featuredProduct = null;
		//if(discount.getDiscount() != 0) {
			for (Product p : products) {
				if (p.getDiscount().getDiscount() == discount.getDiscount()) {
					featuredProduct = p;
					break;
				}
			}
		//}
		return featuredProduct;
	}*/
	
	
}
