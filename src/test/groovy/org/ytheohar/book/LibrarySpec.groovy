package org.ytheohar.book



import static org.hamcrest.core.IsEqual.equalTo;

import java.text.DateFormat;
import java.text.SimpleDateFormat
import java.util.List;


import spock.lang.Specification

class LibrarySpec extends Specification {
	Library library = new Library();
	SimpleDateFormat formatter1 = new SimpleDateFormat("dd MMMMM yyyy");
	SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy");
	      
	def 'Search books by publication year ' () {
		given: "a book with the title 'One good book', written by 'Anonymous', published in 14 March 2013"
		and: "another book with the title 'Some other book', written by 'Tim Tomson', published in 23 August 2014"
		and: "another book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 01 January 2012"
		when: "the customer searches for books published between 2013 and 2014"
		then: "2 books should have been found"
		and: "Book 1 should have the title 'Some other book'"
		and: "Book 2 should have the title 'One good book'"
	}
	
	def 'Search books by publication year' () {
		given: "a book with the title 'One good book', written by 'Anonymous', published in 14 March 2013"
			addBook('One good book', 'Anonymous', '14 March 2013');

		and: "another book with the title 'Some other book', written by 'Tim Tomson', published in 23 August 2014"
			addBook('Some other book', 'Tim Tomson', '23 August 2014');
		
		and: "another book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 01 January 2012"
			addBook('How to cook a dino', 'Fred Flintstone', '01 January 2012');

		when: "the customer searches for books published between 2013 and 2014"
			List<Book> result = library.findBooks(formatter2.parse("2013"), formatter2.parse("2014"));
			
		then: "2 books should have been found"
			result.size() == 2
		
		and: "Book 1 should have the title 'Some other book'"
			result.get(0).getTitle() == 'Some other book'
		
		and: "Book 2 should have the title 'One good book'"
			result.get(1).getTitle() == 'One good book'		
	}
	
	def addBook(String title, String author, String published) {
		Book book3 = new Book(title, author, formatter1.parse(published));
		library.addBook(book3);
	}
}
