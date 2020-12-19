package Entities;

import java.util.Objects;

public class Book {

    private int bookId;
    private String bookTitle, bookAuthor, bookType, bookAddDate, bookImage;
    private Boolean bookAvail;

    public Book() {
    }

    public Book(int bookId, String bookTitle, String bookAuthor, String bookType, String bookAddDate, String bookImage, Boolean bookAvail) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookType = bookType;
        this.bookAddDate = bookAddDate;
        this.bookImage = bookImage;
        this.bookAvail = bookAvail;
    }

    public Book(String bookTitle, String bookAuthor, String bookType, String bookAddDate, String bookImage, Boolean bookAvail) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookType = bookType;
        this.bookAddDate = bookAddDate;
        this.bookImage = bookImage;
        this.bookAvail = bookAvail;
    }

    public Book(String bookTitle, String bookAuthor, String bookType, String bookAddDate, String bookImage) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookType = bookType;
        this.bookAddDate = bookAddDate;
        this.bookImage = bookImage;
    }

    public Book(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    
    

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getBookAddDate() {
        return bookAddDate;
    }

    public void setBookAddDate(String bookAddDate) {
        this.bookAddDate = bookAddDate;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public Boolean getBookAvail() {
        return bookAvail;
    }

    public void setBookAvail(Boolean bookAvail) {
        this.bookAvail = bookAvail;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.bookId;
        hash = 67 * hash + Objects.hashCode(this.bookTitle);
        hash = 67 * hash + Objects.hashCode(this.bookAuthor);
        hash = 67 * hash + Objects.hashCode(this.bookType);
        hash = 67 * hash + Objects.hashCode(this.bookAddDate);
        hash = 67 * hash + Objects.hashCode(this.bookImage);
        hash = 67 * hash + Objects.hashCode(this.bookAvail);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.bookId != other.bookId) {
            return false;
        }
        if (!Objects.equals(this.bookTitle, other.bookTitle)) {
            return false;
        }
        if (!Objects.equals(this.bookAuthor, other.bookAuthor)) {
            return false;
        }
        if (!Objects.equals(this.bookType, other.bookType)) {
            return false;
        }
        if (!Objects.equals(this.bookAddDate, other.bookAddDate)) {
            return false;
        }
        if (!Objects.equals(this.bookImage, other.bookImage)) {
            return false;
        }
        if (!Objects.equals(this.bookAvail, other.bookAvail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookType=" + bookType + ", bookAddDate=" + bookAddDate + ", bookImage=" + bookImage + ", bookAvail=" + bookAvail + '}';
    }
}
