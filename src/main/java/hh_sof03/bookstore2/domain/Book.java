package hh_sof03.bookstore2.domain;


public class Book {

	 	private String title, author, isbn;
	    private int year;
	    private double price;
	    
	    public Book(String isbn, String title, String author, int year, double price)
	    {  
	    	super();
	    	this.isbn=isbn;
	    	this.title=title;
	        this.author=author;
	        this.year=year;
	        this.price=price;
	    }
	    

	   public Book(){}
	 
	   
	   
	    public String getTitle()
	    {
	        return title;
	    }
	    
	     public String getAuthor()
	    {
	        return author;
	    }
	    public int getYear()
	    {
	        return year;
	    }
	    public String getIsbn()
	    {
	        return isbn;
	    } 
	    public double getPrice()
	    {
	        return price;
	    }

	    public void setTitle(String title)
	    {
	        this.title=title;
	    }
	    
	     public void setAuthor(String author)
	    {
	       this.author=author;
	    }
	    public void setYear(int year)
	    {
	        this.year=year;
	    }
	    public void setIsbn(String isbn)
	    {
	        this.isbn=isbn;
	    } 
	    public void setPrice(double price)
	    {
	        this.price=price;
	    }    
	    
	    
	    public String toString()
	    {
	        return  title + ", " + author + ", " + year + ", " + isbn + ", " + price;
	    }
	
}
