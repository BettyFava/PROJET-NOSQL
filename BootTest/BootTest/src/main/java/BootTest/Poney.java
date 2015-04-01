package BootTest;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Poney {
	
	 @Id
	    private String id;

	    private String name;
	    private Integer apples;

	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getApples() {
			return apples;
		}

		public void setApples(Integer apples) {
			this.apples = apples;
		}

		public Poney() {}

	    public Poney(String name, Integer apples) {
	        this.name = name;
	        this.apples = apples;
	    }

	    @Override
	    public String toString() {
	        return String.format(
	                "Poney[id=%s, name='%s', apples='%s']",
	                id, name, apples);
	    }

}
