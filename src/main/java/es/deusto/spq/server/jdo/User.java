package es.deusto.spq.server.jdo;

import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import java.util.HashSet;

@PersistenceCapable(detachable="true")
public class User {
	@PrimaryKey
	String login;
	String password;
	
	
	
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	


	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	 
	 public String toString() {
		
        return "User: login --> " + this.login + ", password -->  " + this.password ;
    }
}
