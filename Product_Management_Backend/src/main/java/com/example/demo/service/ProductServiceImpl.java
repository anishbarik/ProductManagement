package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ProductRepository;
import com.example.demo.model.Product;


@Service
public class ProductServiceImpl  implements ProductService{
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		
		return repo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Product product=repo.findById(id).get();
//first we fetch data of id then we check , if object is present in that id then we delete that 	
		if(product != null)
		{
			repo.delete(product);
			
			return "product deleted ..";
		}
		
		return "product not found..";
		
	}

	@Override
	public Product editProduct(Product p, Integer id) {
		// TODO Auto-generated method stub
		
		Product oldProduct = repo.findById(id).get();
		oldProduct.setProductName(p.getProductName());
		oldProduct.setDescription(p.getDescription());
		oldProduct.setPrice(p.getPrice());
		oldProduct.setStatus(p.getStatus());
		
		
		return repo.save(oldProduct);
	}

}
