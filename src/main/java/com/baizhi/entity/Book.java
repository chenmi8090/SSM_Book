package com.baizhi.entity;

import java.util.Date;

public class Book {

    private String id;
    private String name;
    private String author;
    private Double price;
    private Date createDate;
    private Integer pageNumber;
    private String message;
    private String imgPath;
    private Integer sales;

    public Book() {
    }

    public Book(String id, String name, String author, Double price, Date createDate, Integer pageNumber, String message, String imgPath, Integer sales) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.createDate = createDate;
        this.pageNumber = pageNumber;
        this.message = message;
        this.imgPath = imgPath;
        this.sales = sales;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                ", pageNumber=" + pageNumber +
                ", message='" + message + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", sales=" + sales +
                '}';
    }
}
