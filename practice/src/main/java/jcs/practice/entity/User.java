package jcs.practice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "demoUser")
public class User {

	@Id
	int id;
	String name;
	String place;

}
