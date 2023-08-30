package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Feedback;
import com.example.demo.Repositories.FeedbackRepo;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepo rw;
    
    public Feedback saveinfo(Feedback b)
    {
    	return rw.save(b);
    }
    public List<Feedback> savedetails(List<Feedback> s)
    {
   	 return (List<Feedback>)rw.saveAll(s);
    }
    
    
    public List<Feedback> showinfo()
    {
    	return rw.findAll();
    }
    public Optional<Feedback> showbyid(int id)
    {
    	return rw.findById(id);
    }
    
    
    public Feedback changeinfo(Feedback ss)
    {
    	return rw.saveAndFlush(ss);
    }
    public String updateinfobyid(int id, Feedback s)
    {
    	rw.saveAndFlush(s);
    	if(rw.existsById(id))
    	{
    		return "updated";
    	}
 		return "enter valid id";
    }
    
    
    public void deleteinfo(Feedback ss)
    {
    	 rw.delete(ss);
    }
    public void deleteid(int id)
    {
    	rw.deleteById(id);
    }
    
    //sorting and pagination
    public List<Feedback> page(int pgno,int pgsize,String s)
    {
 	   Page <Feedback> c = rw.findAll(PageRequest.of(pgno, pgsize, (Sort.by(Sort.Direction.ASC,s))));
 	   return c.getContent();
    }
}