package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Payment;
import com.example.demo.Repositories.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
    PaymentRepo r;
	 public Payment saveinfo(Payment ss)
	    {
	       return r.save(ss);     
	    }
	    public List<Payment> saveasList(List<Payment> ss)
	    {
	    	return r.saveAll(ss);
	    }
	    
	    public List<Payment> showinfo()
	    {
	    	return r.findAll();	
	    }
	    
	    public Optional<Payment> showId(int id)
	    {
	    	return r.findById(id);
	    }
	    public List<Payment> showsortinfo(String s)
	    {
	    	return r.findAll(Sort.by(Sort.Direction.ASC,s));	
	    }
	    public List<Payment>  showbypage(int pgno,int size)
	    {
	    	Page<Payment> p = r.findAll(PageRequest.of(pgno, size));
	    	return p.getContent();
	    }
	    public List<Payment>  showbypageSort(int pgno,int size,String s)
	    {
	    	Page<Payment> p = r.findAll(PageRequest.of(pgno, size,(Sort.by(Sort.Direction.ASC,s))));
	    	return p.getContent();
	    }
	    public String changeInfo(Payment ss)
	    {
	    	r.saveAndFlush(ss);
	    	return "Updated";
	    }
	    
	    public String changebyId(int id,@RequestBody Payment ss)
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
