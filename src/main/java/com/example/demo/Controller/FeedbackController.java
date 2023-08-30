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

import com.example.demo.Model.Feedback;
import com.example.demo.Service.FeedbackService;

@RestController
public class FeedbackController {
   @Autowired
   FeedbackService rss;
   
   @PostMapping("adding5")
	public Feedback add(@RequestBody Feedback  ss)
	{
		return rss.saveinfo(ss);
	}
  @PostMapping("addingn5")
	public List<Feedback> addn(@RequestBody List<Feedback> ss)
	{
		return rss.savedetails(ss);
	}

  @GetMapping("showingdetails5")
	public List<Feedback> show()
	{
		return rss.showinfo();
	}
  @GetMapping("showingid5/{id}")
  public Optional<Feedback> showid(@PathVariable int id)
  {
 	 return rss.showbyid(id);
  }
  
  @PutMapping("update5")
 	public Feedback  modify(@RequestBody Feedback ss)
 	{
 		return rss.changeinfo(ss);
 	}
    @PutMapping("updatebyid5/{id}")
     public String modifybyid(@PathVariable int id,@RequestBody Feedback b)
     {
     	return rss.updateinfobyid(id, b);
     }
    
    
    @DeleteMapping("delete5")
	public String deleteInfo(@RequestBody Feedback ss)
	{
	      rss.deleteinfo(ss);
	      return "Deleted successfully";
	}
    @DeleteMapping("deleteid5/{id}")
	public void deletemyid(@PathVariable int id)
	{
		rss.deleteid(id);
	}
    
  //sorting and paging
    @GetMapping("page/{pgno}/{pgsi}/{s}")
    public List<Feedback> showpage(@PathVariable int pgno,@PathVariable int pgsi,@PathVariable String s)
    {
  	  return rss.page(pgno, pgsi, s);
    }
}