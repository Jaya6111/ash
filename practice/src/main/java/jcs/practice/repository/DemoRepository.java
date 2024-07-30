package jcs.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jcs.practice.entity.Been;

@Repository
public interface DemoRepository extends JpaRepository<Been, Integer>  {

	
	
}
