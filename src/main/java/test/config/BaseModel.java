package test.config;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class BaseModel implements Serializable{
	
	private long id;
	
	public long getId(){
		return 111L;
	}
	
}
