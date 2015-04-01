package BootTest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

public class ArticleRepo
{
	static final Logger logger = LoggerFactory.getLogger(Article.class);
	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<Article> allArticles()
	{
		List<Article> result = null;
		
		if(mongoTemplate.collectionExists(Article.class))
		{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC, "createddate"));
			result = mongoTemplate.find(query, Article.class);
		}
		else
		{
			//TODO rase error
			logger.error(Article.class.toString() + " collection not found");
		}
		return(result);
	}
	
	public Article getArticleById(String id)
	{
		Article result = null;
		
		if(mongoTemplate.collectionExists(Article.class))
		{
			BasicQuery query = new BasicQuery("{_id:" + id + "}");
			result = mongoTemplate.findOne(query, Article.class);
		}
		else
		{
			//TODO rase error
			logger.error(Article.class.toString() + " collection not found");
		}
		return(result);
	}
		
	/*TODO
	public Article getArticleByAuthor(String author){}
	public Article getArticleByYear(Date author){}
	public Article getArticleByMonth(Date author){}
	public Article getArticleByDay(Date author){}

	*/
}
