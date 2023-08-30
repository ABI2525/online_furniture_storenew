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
import com.example.demo.Model.Orders;
import com.example.demo.Service.OrdersService;

@RestController
public class OrdersController {
 
	 @Autowired
	 OrdersService o;
	 @PostMapping("addneword")
		public Orders getInfo(@RequestBody Orders ss)
		{
			return o.saveinfo(ss);
		}
		
		@PostMapping("addnewlistord")
		public List<Orders> getInfoList(@RequestBody List<Orders> ss)
		{
			return o.saveasList(ss);
		}
		
		@GetMapping("showord")
		public List<Orders> showInfo()
		{	
			return o.showinfo();
		}
		
		@GetMapping("showordbyid/{id}")
		public Optional<Orders> showInfoById(@PathVariable int  id)
		{
			return o.showId(id);
		}
		@GetMapping("showordsort/{name}")
		public List<Orders> show(@PathVariable String name)
		{
			return o.showsortinfo(name);
		}
		@GetMapping("showordbypage/{pageno}/{pgsize}")
		public List<Orders> showinfobypage(@PathVariable int pageno,@PathVariable int pgsize)
		{
			return o.showbypage(pageno, pgsize);
		}
		@GetMapping("showordbypagesort/{pageno}/{pgsize}/{name}")
		public List<Orders> showinfobypageSort(@PathVariable int pageno,@PathVariable int pgsize,@PathVariable String name)
		{
			return o.showbypageSort(pageno, pgsize,name);
		}
		@PutMapping("updateord")
		public String updateInfo(@RequestBody Orders ss)
		{
			return o.changeInfo(ss);
		}
		
		@PutMapping("updateordbyid/{id}")
		public String updateInfoById(@PathVariable int  id,@RequestBody Orders ss)
		{
			return o.changebyId(id,ss);
		}
		
		@DeleteMapping("deleteord")
		public String deleteAll()
		{
			return o.delete();
		}
		
		@DeleteMapping("deleteOrdById/{id}")
		public String deleteById(@PathVariable int id)
		{
			return o.deleteById(id);
		}
}
