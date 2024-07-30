package jcs.practice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "demo")
@Getter
@Setter
public class Been {
	
	@Id
	int id;
	
	String message;

}
