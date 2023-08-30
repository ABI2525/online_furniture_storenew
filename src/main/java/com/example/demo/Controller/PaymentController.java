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

import com.example.demo.Model.Payment;
import com.example.demo.Service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService  o;
	 @PostMapping("addnewpay")
		public Payment getInfo(@RequestBody Payment ss)
		{
			return o.saveinfo(ss);
		}
		
		@PostMapping("addnewlistpay")
		public List<Payment> getInfoList(@RequestBody List<Payment> ss)
		{
			return o.saveasList(ss);
		}
		
		@GetMapping("showpay")
		public List<Payment> showInfo()
		{	
			return o.showinfo();
		}
		
		@GetMapping("showpaybyid/{id}")
		public Optional<Payment> showInfoById(@PathVariable int  id)
		{
			return o.showId(id);
		}
		@GetMapping("showpaysort/{name}")
		public List<Payment> show(@PathVariable String name)
		{
			return o.showsortinfo(name);
		}
		@GetMapping("showpaybypage/{pageno}/{pgsize}")
		public List<Payment> showinfobypage(@PathVariable int pageno,@PathVariable int pgsize)
		{
			return o.showbypage(pageno, pgsize);
		}
		@GetMapping("showpaybypagesort/{pageno}/{pgsize}/{name}")
		public List<Payment> showinfobypageSort(@PathVariable int pageno,@PathVariable int pgsize,@PathVariable String name)
		{
			return o.showbypageSort(pageno, pgsize,name);
		}
		@PutMapping("updateapay")
		public String updateInfo(@RequestBody Payment ss)
		{
			return o.changeInfo(ss);
		}
		
		@PutMapping("updatepaybyid/{id}")
		public String updateInfoById(@PathVariable int  id,@RequestBody Payment ss)
		{
			return o.changebyId(id,ss);
		}
		
		@DeleteMapping("deletepay")
		public String deleteAll()
		{
			return o.delete();
		}
		
		@DeleteMapping("deletepaybyid/{id}")
		public String deleteById(@PathVariable int id)
		{
			return o.deleteById(id);
		}

}
