package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Cart;
import com.example.demo.Repositories.CartRepo;

@Service
public class CartService {
   
	@Autowired
	CartRepo r;
	 public Cart saveinfo(Cart ss)
	    {
	       return r.save(ss);     
	    }
	    public List<Cart> saveasList(List<Cart> ss)
	    {
	    	return r.saveAll(ss);
	    }
	    
	    public List<Cart> showinfo()
	    {
	    	return r.findAll();	
	   }
	    
	    public Optional<Cart> showId(int id)
	    {
	    	return r.findById(id);
	    }
	    public List<Cart> showsortinfo(String s)
	    {
	    	return r.findAll(Sort.by(Sort.Direction.ASC,s));	
	    }
	    public List<Cart>  showbypage(int pgno,int size)
	    {
	    	Page<Cart> p = r.findAll(PageRequest.of(pgno, size));
	    	return p.getContent();
	    }
	    public List<Cart>  showbypageSort(int pgno,int size,String s)
	    {
	    	Page<Cart> p = r.findAll(PageRequest.of(pgno, size,(Sort.by(Sort.Direction.ASC,s))));
	    	return p.getContent();
	    }	    
	    public String changeInfo(Cart ss)
	    {
	    	r.saveAndFlush(ss);
	    	return "Updated";
	    }
	    
	    public String changebyId(int id,@RequestBody Cart ss)
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
