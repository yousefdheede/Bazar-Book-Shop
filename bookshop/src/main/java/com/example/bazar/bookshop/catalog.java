package com.example.bazar.bookshop;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


@EnableAutoConfiguration(exclude={JmxAutoConfiguration.class})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@Configuration
@ComponentScan
@EnableScheduling
@Component
@RequestMapping("/ListBooks")
@RestController
public class catalog {

	
	List<book> books=Arrays.asList(
			new book("1","How to get a good grade in DOS in 40 minutes a day","distributed systems","40$","50"),
						
						new book("2","RPCs for Noobs","distributed systems","30$","30"),

						new book("3","Xen and the Art of Surviving Undergraduate School","undergraduate school","20$","40"),

						new book("4","Cooking for the Impatient Undergrad","undergraduate school","25$","60")
						);
	public String x="this book  , %s .";
	public final AtomicLong bo=new AtomicLong();
	
	
@GetMapping("/books")
public List<book>ListBooks(){
	
	
			return books;

	}
@GetMapping("/books")
public String printall() {
	book b=new book();
	return(b.toString());
}



@GetMapping("/books")
	public book getbookbyType(@RequestParam(value="type")String type){
	
	book b=books.stream().filter(book-> type.equals(book.getType())).findAny().orElse(null);
   //book k=new book(bo.incrementAndGet(),String.format(x, type));
		return b;
		
	}

@GetMapping("/books")
@ResponseBody
public String getbookbyT(@RequestParam String type){
	return "type: "+type ;
	
}

@GetMapping("/books")
public book getbookbyID(@RequestParam(value="id")String id){

book k=new book(bo.incrementAndGet(),String.format(x, id));
	return k;
	
}

@GetMapping("/books")
public book getbookbybookname(@RequestParam(value="bookname")String bookname){

book k=new book(bo.incrementAndGet(),String.format(x, bookname));
	return k;
	
}




	@RequestMapping("/books/{Id}")
public book getbookbyID1(@PathVariable("Id")String Id){
	book b=books.stream().filter(book-> Id.equals(book.getid())).findAny().orElse(null);
	
	return b  ;
		
	}
@RequestMapping("/books/{bookname}")
public book getbookName(@PathVariable("bookname")String bookname){
	book b=books.stream().filter(book-> bookname.equals(book.getBookname())).findAny().orElse(null);

	return b;
	
}


	
}
