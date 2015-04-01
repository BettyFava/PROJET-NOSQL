package BootTest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;
@Service
public class PoneyRepo {
	
	static final Logger logger = LoggerFactory.getLogger(PoneyRepo.class);
	  @Autowired
	  MongoTemplate mongoTemplate;

	  public   List<Poney> allPoneys() {
	  List<Poney> results = mongoTemplate.findAll(Poney.class);
	  logger.info("Total amount of poneys: {}", results.size());
	    logger.info("Results: {}", results);
	    return results;
	  }
	  public  Poney OnePoney() {
		  	BasicQuery query1 = new BasicQuery("{name:'Aurora'}");
		  	Poney results = mongoTemplate.findOne(query1, Poney.class);
		  	logger.info("name", results);
		  
		    return results;
		  }
}
