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

import com.example.demo.Model.Cart;
import com.example.demo.Service.CartService;

@RestController
public class CartController {

	@Autowired
	CartService o;
	
	 @PostMapping("addnewcart")
		public Cart getInfo(@RequestBody Cart ss)
		{
			return o.saveinfo(ss);
		}
		
		@PostMapping("addnewlistcart")
		public List<Cart> getInfoList(@RequestBody List<Cart> ss)
		{
			return o.saveasList(ss);
		}
		
		@GetMapping("showcart")
		public List<Cart> showInfo()
		{	
			return o.showinfo();
		}
		
		@GetMapping("showcartbyid/{id}")
		public Optional<Cart> showInfoById(@PathVariable int  id)
		{
			return o.showId(id);
		}
		@GetMapping("showcartsort/{name}")
		public List<Cart> show(@PathVariable String name)
		{
			return o.showsortinfo(name);
		}
		@GetMapping("showcartbypage/{pageno}/{pgsize}")
		public List<Cart> showinfobypage(@PathVariable int pageno,@PathVariable int pgsize)
		{
			return o.showbypage(pageno, pgsize);
		}
		@GetMapping("showcartbypagesort/{pageno}/{pgsize}/{name}")
		public List<Cart> showinfobypageSort(@PathVariable int pageno,@PathVariable int pgsize,@PathVariable String name)
		{
			return o.showbypageSort(pageno, pgsize,name);
		}
		@PutMapping("updatecart")
		public String updateInfo(@RequestBody Cart ss)
		{
			return o.changeInfo(ss);
		}
		
		@PutMapping("updatebyidcart/{id}")
		public String updateInfoById(@PathVariable int  id,@RequestBody Cart ss)
		{
			return o.changebyId(id,ss);
		}
		
		@DeleteMapping("deletecart")
		public String deleteAll()
		{
			return o.delete();
		}
		
		@DeleteMapping("deletecartbyid/{id}")
		public String deleteById(@PathVariable int id)
		{
			return o.deleteById(id);
		}

}
