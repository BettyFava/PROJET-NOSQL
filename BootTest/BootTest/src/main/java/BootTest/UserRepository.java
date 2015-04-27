package BootTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class UserRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	static final Logger logger = LoggerFactory.getLogger(User.class);
	
	public User getUser(String pseudonyme, String password)
	{
		if(mongoTemplate.collectionExists(User.class))
		{
			Query query =  new Query(Criteria.where("pseudonyme").is(pseudonyme).and("password").is(password));
			User result = mongoTemplate.findOne(query, User.class);
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
