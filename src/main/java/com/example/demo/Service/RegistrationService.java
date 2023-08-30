package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.Registration;
import com.example.demo.Repositories.RegistrationRepo;

@Service
public class RegistrationService {
    @Autowired
    RegistrationRepo r;
    
    public Registration saveinfo(Registration ss)
    {
       return r.save(ss);     
    }
    public List<Registration> saveasList(List<Registration> ss)
    {
    	return r.saveAll(ss);
    }
    
    public List<Registration> showinfo()
    {
    	return r.findAll();	
    }
    public List<Registration> showsortinfo(String s)
    {
    	return r.findAll(Sort.by(Sort.Direction.ASC,s));	
    }
    public List<Registration>  showbypage(int pgno,int size)
    {
    	Page<Registration> p = r.findAll(PageRequest.of(pgno, size));
    	return p.getContent();
    }
    public List<Registration>  showbypageSort(int pgno,int size,String s)
    {
    	Page<Registration> p = r.findAll(PageRequest.of(pgno, size,(Sort.by(Sort.Direction.ASC,s))));
    	return p.getContent();
    }
    public Optional<Registration> showId(int id)
    {
    	return r.findById(id);
    }
    public List<Registration> showQuery(String name)
    {
    	return r.getNameReg(name);
    }
    public String changeInfo(Registration ss)
    {
    	r.saveAndFlush(ss);
    	return "Updated";
    }
    
    public String changebyId(int id,@RequestBody Registration ss)
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
