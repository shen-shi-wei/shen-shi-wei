package com.lanou.bookstore.book.domain;

public class Book {
    private int bid;
    private String bname;

    public Book(int bid, String bname, double price, String author, String image, int cid) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.image = image;
        this.cid = cid;
    }

    private double price;
    private String author;
    private String image;
    private int cid;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Book{" + "bid=" + bid + ", bname='" + bname + '\'' + ", price=" + price + ", author='" + author + '\'' + ", image='" + image + '\'' + ", cid=" + cid + '}';
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {

    }
}
