package com.example.bazar.bookshop;

public class book {

	public book(String id, String bookname, String type, String price, String stock) {
	
		this.id = id;
		this.bookname = bookname;
		this.type = type;
		this.price = price;
		this.stock = stock;
	}

	private String id;
	private  String bookname;
	private  String type;
	private  String price;
	private  String stock;
	

public book() {
	
}

public book(String id, String bookname, String type) {
	this.id = id;
	this.bookname = bookname;
	this.type = type;
}

public book(long incrementAndGet, String format) {
	// TODO Auto-generated constructor stub
}

public String getid() {
	return id;
}

public void setid(String id) {
	this.id = id;
}

public String getBookname() {
	return bookname;
}

public void setBookname(String bookname) {
	this.bookname = bookname;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getStock() {
	return stock;
}
public String search(String x) {
	if(x==this.getBookname()) {
		return(this.id+this.bookname+this.type+this.price);
	}
	else if(x==this.id) {
		return(this.id+this.bookname+this.type+this.price);
	}
	else if(x==this.type) {
		return(this.id+this.bookname+this.type+this.price);
	}
	else return("this search is not working");
}

public void setStock(String stock) {
	this.stock = stock;
}
public void main(String[]args) {
	book b1=new book("1","How to get a good grade in DOS in 40 minutes a day","distributed systems","40$","50");
			
	book b2=new book("2","RPCs for Noobs","distributed systems","30$","30");
	
	book b3=new book("3","Xen and the Art of Surviving Undergraduate School","undergraduate school","20$","40");

	book b4=new book("4","Cooking for the Impatient Undergrad","undergraduate school","25$","60");

	
	
}






	
	
}
