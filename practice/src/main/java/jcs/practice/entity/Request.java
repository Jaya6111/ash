package jcs.practice.entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {

	String name;

	MultipartFile pdf;
}
