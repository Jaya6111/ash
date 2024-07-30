package com.rs.app.bean;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "Mybooks")
@Getter
@Setter
public class MyBooks {
    
    @Id
    private String id;
    @Field
    private String uId;
    @Field
    private Set<String> pIds;
}
