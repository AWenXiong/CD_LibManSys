package org.library.entity;

import java.util.Objects;

public class book {
    private String bookId;
    private String bookName;
    private Integer bookTotal;
    private Integer bookStock;
    private String bookWriter;
    private String bookPress;
    private String bookType;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookTotal() {
        return bookTotal;
    }

    public void setBookTotal(int bookTotal) {
        this.bookTotal = bookTotal;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public book(String bookId, String bookName, String bookWriter, String bookPress, String bookType, Integer bookStock, Integer bookTotal) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookTotal = bookTotal;
        this.bookStock = bookStock;
        this.bookWriter = bookWriter;
        this.bookPress = bookPress;
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookTotal=" + bookTotal +
                ", bookStock=" + bookStock +
                ", bookWriter='" + bookWriter + '\'' +
                ", bookPress='" + bookPress + '\'' +
                ", bookType='" + bookType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof book)) return false;
        book book = (book) o;
        return Objects.equals(getBookId(), book.getBookId()) &&
                Objects.equals(getBookName(), book.getBookName()) &&
                Objects.equals(getBookWriter(), book.getBookWriter()) &&
                Objects.equals(getBookPress(), book.getBookPress()) &&
                Objects.equals(getBookType(), book.getBookType());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBookId(), getBookName(), getBookWriter(), getBookPress(), getBookType());
    }
}
