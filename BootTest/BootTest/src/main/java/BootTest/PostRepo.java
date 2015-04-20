package BootTest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class PostRepo
{
	static final Logger logger = LoggerFactory.getLogger(Post.class);
	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<Post> allPost()
	{
		List<Post> result = null;
		
		if(mongoTemplate.collectionExists(Post.class))
		{
			Query query = new Query();
			result = mongoTemplate.find(query, Post.class);
		}
		else
		{
			//TODO rase error
			logger.error(Post.class.toString() + " collection not found");
		}
		return(result);
	}
	
	public Post getPostById(String id)
	{
		Post result = null;
		
		if(mongoTemplate.collectionExists(Post.class))
		{
			BasicQuery query = new BasicQuery("{_id:" + id + "}");
			result = mongoTemplate.findOne(query, Post.class);
		}
		else
		{
			//TODO rase error
			logger.error(Post.class.toString() + " collection not found");
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
