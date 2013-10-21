package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.pojo.Representative;

public interface IRepresentative extends JpaRepository<Representative,String>{

}
