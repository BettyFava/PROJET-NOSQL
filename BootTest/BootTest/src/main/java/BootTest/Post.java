package BootTest;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post
{
	@Id
    private String id;
	
	private String title;
	private String author;
	private String content;
	private Date creation;
	
	public Post()
	{
		this("Title","Author","Content");
	}
	
	public Post(String title, String author, String content)
	{
		this.title = title;
		this.author = author;
		this.content = content;
		this.creation = new Date();
	}
	
	public String getId() {
		return id;
	}

/*	public void setId(String id) {
		this.id = id;
	}*/

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}
}