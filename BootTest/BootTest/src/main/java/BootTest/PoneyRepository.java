package BootTest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface PoneyRepository extends MongoRepository<Poney, String> {
	
	 public Poney findByName(String name);

}
