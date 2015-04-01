package BootTest;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class RapportDeSante implements HealthIndicator{

//	@Override
//	public Health health() {
//		 return Health.up()
//	                .withDetail("Test FAKE", "Fonctionne")
//	                .withDetail("TEST BDD", "Five by Five")
//	                .build();
//	}
	
	
	 @Override
	    public Health health() {
	        return Health.down(new RuntimeException("Erreur lors de l'execution"))
	                .withDetail("BACKUP TEST", "Impossible")
	                .build();
	    }
	

}
