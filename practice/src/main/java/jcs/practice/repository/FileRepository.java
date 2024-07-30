package jcs.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jcs.practice.entity.ImageData;

@Repository
public interface FileRepository extends JpaRepository<ImageData,Long> {


    Optional<ImageData> findByName(String fileName);
}