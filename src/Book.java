public class Book implements Library{

	private String ISBN;
	private String BookTitle;
	private String BookAuthor;
	private String BookYear;

	public Book(String ISBN, String BookTitle, String BookAuthor, String BookYear) {
		this.ISBN = ISBN;
		this.BookTitle = BookTitle;
		this.BookAuthor = BookAuthor;
		this.BookYear = BookYear;
	}

	public Book() {

	}


	public String getISBN() {
		return ISBN;
	}

	@Override
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getBookTitle() {
		return BookTitle;
	}

	@Override
	public void setBookTitle(String BookTitle) {
		this.BookTitle = BookTitle;
	}

	public String getBookAuthor() {
		return BookAuthor;
	}

	@Override
	public void setBookAuthor(String BookAuthor) {
		this.BookAuthor = BookAuthor;
	}

	public String getBookYear() {
		return BookYear;
	}

	@Override
	public void setBookYear(String BookYear) {
		this.BookYear = BookYear;
	}

}