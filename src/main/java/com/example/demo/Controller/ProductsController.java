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
import com.example.demo.Model.Products;
import com.example.demo.Service.ProductsService;

@RestController
public class ProductsController {

	 @Autowired
	 ProductsService o;
	 @PostMapping("addnewpro")
		public Products getInfo(@RequestBody Products ss)
		{
			return o.saveinfo(ss);
		}
		
		@PostMapping("addnewlistpro")
		public List<Products> getInfoList(@RequestBody List<Products> ss)
		{
			return o.saveasList(ss);
		}
		
		@GetMapping("showpro")
		public List<Products> showInfo()
		{	
			return o.showinfo();
		}
		
		@GetMapping("showprobyid/{id}")
		public Optional<Products> showInfoById(@PathVariable int  id)
		{
			return o.showId(id);
		}
		@GetMapping("showprosort/{name}")
		public List<Products> show(@PathVariable String name)
		{
			return o.showsortinfo(name);
		}
		@GetMapping("showprobypage/{pageno}/{pgsize}")
		public List<Products> showinfobypage(@PathVariable int pageno,@PathVariable int pgsize)
		{
			return o.showbypage(pageno, pgsize);
		}
		@GetMapping("showprobypagesort/{pageno}/{pgsize}/{name}")
		public List<Products> showinfobypageSort(@PathVariable int pageno,@PathVariable int pgsize,@PathVariable String name)
		{
			return o.showbypageSort(pageno, pgsize,name);
		}
		@PutMapping("updatepro")
		public String updateInfo(@RequestBody Products ss)
		{
			return o.changeInfo(ss);
		}

		@PutMapping("updateprobyid/{id}")
		public String updateInfoById(@PathVariable int  id,@RequestBody Products ss)
		{
			return o.changebyId(id,ss);
		}
		
		@DeleteMapping("deletepro")
		public String deleteAll()
		{
			return o.delete();
		}
		
		@DeleteMapping("deleteprobyid/{id}")
		public String deleteById(@PathVariable int id)
		{
			return o.deleteById(id);
		}
}
