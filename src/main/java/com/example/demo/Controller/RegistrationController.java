package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Registration;
import com.example.demo.Service.RegistrationService;

@RestController
public class RegistrationController {
 
	@Autowired
	RegistrationService o;
	
	@PostMapping("addnewreg")
	public Registration getInfo(@RequestBody Registration ss)
	{
		return o.saveinfo(ss);
	}
	
	@PostMapping("addnewlistreg")
	public List<Registration> getInfoList(@RequestBody List<Registration> ss)
	{
		return o.saveasList(ss);
	}
	
	@GetMapping("showreg")
	public List<Registration> showInfo()
	{	
		return o.showinfo();
	}
	
	@GetMapping("showregbyid/{id}")
	public Optional<Registration> showInfoById(@PathVariable int  id)
	{
		return o.showId(id);
	}
	
	@GetMapping("showregsort/{name}")
	public List<Registration> show(@PathVariable String name)
	{
		return o.showsortinfo(name);
	}
	@GetMapping("showregbypage/{pageno}/{pgsize}")
	public List<Registration> showinfobypage(@PathVariable int pageno,@PathVariable int pgsize)
	{
		return o.showbypage(pageno, pgsize);
	}
	@GetMapping("showregbypagesort/{pageno}/{pgsize}/{name}")
	public List<Registration> showinfobypageSort(@PathVariable int pageno,@PathVariable int pgsize,@PathVariable String name)
	{
		return o.showbypageSort(pageno, pgsize,name);
	}
	@GetMapping("showbyquery/{name}")
	public List<Registration> showbyQuery(@PathVariable String name)
	{
		return o.showQuery(name);
	}
	@PutMapping("updatereg")
	public String updateInfo(@RequestBody Registration ss)
	{
		return o.changeInfo(ss);
	}
	
	@PutMapping("updateregbyid/{id}")
	public String updateInfoyId(@PathVariable int  id,@RequestBody Registration ss)
	{
		return o.changebyId(id,ss);
	}
	
	@DeleteMapping("deletereg")
	public String deleteAll()
	{
		return o.delete();
	}
	
	@DeleteMapping("deleteregbyid/{id}")
	public String deleteById(@PathVariable int id)
	{
		return o.deleteById(id);
	}
}
