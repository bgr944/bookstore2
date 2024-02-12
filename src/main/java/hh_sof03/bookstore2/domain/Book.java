package hh_sof03.bookstore2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {


		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		private String title, author, isbn;


		@Column(name = "release_year")
	    private int year;
		private double price;
		
		@ManyToOne
		@JoinColumn(name = "categoryId")
		private Category category;

	    
	    public Book(String isbn, String title, String author, int year, double price, Category category)
	    {  
	    	super();
	    	this.isbn=isbn;
	    	this.title=title;
	        this.author=author;
	        this.year=year;
			this.price = price;
			this.category = category;
	    }
	    

		public Book() {
		}
	 
		public Long getId()
	    {
	        return id;
	    }

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

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public void setId(long id)
	    {
	        this.id = id;
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
	    
	    @Override
	    public String toString()
	    {
	        return  title + ", " + author + ", " + year + ", " + isbn + ", " + price;
	    }
	
}
