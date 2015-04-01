package BootTest;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Article
{
	@Id
    private String id;
	
	private String title;
	private String subtilte;
	private Date createddate;
	private String author;
	private String content;
	List<String> keywords;
	
	public Article(String title, String subtilte, String author, String content, List<String> keywords)
	{
		this.title = title;
		this.subtilte = subtilte;
		this.createddate = new Date();
		this.author = author;
		this.content = content;
		this.keywords = keywords;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtilte() {
		return subtilte;
	}

	public void setSubtilte(String subtilte) {
		this.subtilte = subtilte;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
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

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
}
