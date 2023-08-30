package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Orders;
import com.example.demo.Repositories.OrdersRepo;

@Service
public class OrdersService {
 
	 @Autowired
	 OrdersRepo r;
	 public Orders saveinfo(Orders ss)
	    {
	       return r.save(ss);     
	    }
	    public List<Orders> saveasList(List<Orders> ss)
	    {
	    	return r.saveAll(ss);
	    }
	    
	    public List<Orders> showinfo()
	    {
	    	return r.findAll();	
	    }
	    
	    public Optional<Orders> showId(int id)
	    {
	    	return r.findById(id);
	    }
	    public List<Orders> showsortinfo(String s)
	    {
	    	return r.findAll(Sort.by(Sort.Direction.ASC,s));	
	    }
	    public List<Orders>  showbypage(int pgno,int size)
	    {
	    	Page<Orders> p = r.findAll(PageRequest.of(pgno, size));
	    	return p.getContent();
	    }
	    public List<Orders>  showbypageSort(int pgno,int size,String s)
	    {
	    	Page<Orders> p = r.findAll(PageRequest.of(pgno, size,(Sort.by(Sort.Direction.ASC,s))));
	    	return p.getContent();
	    }
	    public String changeInfo(Orders ss)
	    {
	    	r.saveAndFlush(ss);
	    	return "Updated";
	    }
	    
	    public String changebyId(int id,@RequestBody Orders ss)
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
