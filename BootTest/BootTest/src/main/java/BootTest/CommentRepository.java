package BootTest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class CommentRepository {

	
	@Autowired
	MongoTemplate mongoTemplate;
	
	static final Logger logger = LoggerFactory.getLogger(Post.class);
	
	public List<Post> getAllCommentForPost(String id)
	{
		if(mongoTemplate.collectionExists(Post.class))
		{
			Query query =  new Query(Criteria.where("post_id").is(id));
			List<Post> result = mongoTemplate.find(query, Post.class);
			return result;
		}
		else
		{
			//TODO raise error
			logger.error(Post.class.toString() + " collection not found");
		}
		return(null);
	
}
	
}
