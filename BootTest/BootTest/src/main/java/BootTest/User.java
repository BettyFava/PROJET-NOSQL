package BootTest;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String id;
	private String pseudonyme;
	private String password;

	public String getPseudonyme() {
		return pseudonyme;
	}

	public void setPseudonyme(final String pseudonyme) {
		this.pseudonyme = pseudonyme;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

