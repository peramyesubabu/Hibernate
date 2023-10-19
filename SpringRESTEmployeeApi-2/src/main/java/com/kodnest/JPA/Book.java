package com.kodnest.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="book")//for this program we no need to write get mapping spring is giving the end points as
//it is book:as "books"
public class Book {
@Id
@Column(name="Id")
@GeneratedValue(strategy = GenerationType.IDENTITY.AUTO)
int Id;
@Column(name="Title")
String Title;
@Column(name="Author")
String Author;
@Column(name="Price")
int Price;
public Book() {
	super();
}
public Book(String title, String author, int price) {
	super();
	Title = title;
	Author = author;
	Price = price;
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getTitle() {
	return Title;
}
public void setTitle(String title) {
	Title = title;
}
public String getAuthor() {
	return Author;
}
public void setAuthor(String author) {
	Author = author;
}
public int getPrice() {
	return Price;
}
public void setPrice(int price) {
	Price = price;
}
@Override
public String toString() {
	return "Book [Id=" + Id + ", Title=" + Title + ", Author=" + Author + ", Price=" + Price + "]";
}

}
