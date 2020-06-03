package com.kh.team.model.vo;

public class Book {
   
   private int bookNum;
   private String bookName;
   private int price;
   private String author;
   private int bookClass;

   public Book() {

   }
   
   //   생성자
   public Book(int bookNum, String bookName, int price, String author, int bookClass) {
      super();
      this.bookNum = bookNum;
      this.bookName = bookName;
      this.price = price;
      this.author = author;
      this.bookClass = bookClass;
   }

   //   getter/setter
   public int getBookNum() {
      return bookNum;
   }


   public void setBookNum(int bookNum) {
      this.bookNum = bookNum;
   }


   public String getBookName() {
      return bookName;
   }


   public void setBookName(String bookName) {
      this.bookName = bookName;
   }


   public int getPrice() {
      return price;
   }


   public void setPrice(int price) {
      this.price = price;
   }


   public String getAuthor() {
      return author;
   }


   public void setAuthor(String author) {
      this.author = author;
   }


   public int getBookClass() {
      return bookClass;
   }


   public void setBookClass(int bookClass) {
      this.bookClass = bookClass;
   }

   ////////
   @Override
   public String toString() {
      return "Member [bookNum=" + bookNum + ", bookName=" + bookName + ", price=" + price + ", author=" + author
            + ", bookClass=" + bookClass + "]";
   }
   
   
}