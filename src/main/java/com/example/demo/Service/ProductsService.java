package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Products;
import com.example.demo.Repositories.ProductsRepo;

@Service
public class ProductsService {
 
	@Autowired
	ProductsRepo r;
	 public Products saveinfo(Products ss)
	    {
	       return r.save(ss);     
	    }
	    public List<Products> saveasList(List<Products> ss)
	    {
	    	return r.saveAll(ss);
	    }
	    
	    public List<Products> showinfo()
	    {
	    	return r.findAll();	
	    }
	    
	    public Optional<Products> showId(int id)
	    {
	    	return r.findById(id);
	    }
	    public List<Products> showsortinfo(String s)
	    {
	    	return r.findAll(Sort.by(Sort.Direction.ASC,s));	
	    }
	    public List<Products>  showbypage(int pgno,int size)
	    {
	    	Page<Products> p = r.findAll(PageRequest.of(pgno, size));
	    	return p.getContent();
	    }
	    public List<Products>  showbypageSort(int pgno,int size,String s)
	    {
	    	Page<Products> p = r.findAll(PageRequest.of(pgno, size,(Sort.by(Sort.Direction.ASC,s))));
	    	return p.getContent();
	    }
	    public String changeInfo(Products ss)
	    {
	    	r.saveAndFlush(ss);
	    	return "Updated";
	    }
	    
	    public String changebyId(int id,@RequestBody Products ss)
	    {
	    	if(r.existsById(id))
	    	{
	    	   r.saveAndFlush(ss);
	    	   return "updated SuccessFully";
	    	}
	    	return "Invalid id";
	    }
	    
	    public String delete()
	    {
	    	r.deleteAll();
	    	return "deleted";
	    }
	    public String deleteById(int id)
	    {
	    	if(r.existsById(id))
	    	{
	    		r.deleteById(id);
	    		return "Deleted Successfully ";
	        }
	    	return "Invalid Id Please Try Again ";
	    }
}
