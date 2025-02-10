package com.pocv01.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocv01.Entity.UserEntity;
import com.pocv01.model.Menu;
import com.pocv01.model.User;
import com.pocv01.repository.userRepository;


@Service
public class menuService {

	

	
	
	
	
	public static  List<Menu> menu(User session) {
		java.util.List<Menu> menuList = null;
		 ObjectMapper objectMapper = new ObjectMapper();
		 try {
			 menuList = objectMapper.readValue(new File("D:\\sampingan\\tools\\samplejson\\datamenutest.json"), new TypeReference<List<Menu>>(){});
			 	UserEntity useEntity = new UserEntity();
		        useEntity.setUserId("bintangs");
		        useEntity.setPassword("ancoleees");
		        useEntity.setIsActive("active");
		        useEntity.setModifyDate(new java.sql.Date(System.currentTimeMillis()));
		        useEntity.setCreationDate(new java.sql.Date(System.currentTimeMillis()));
		        
		       
		        
		       
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return menuList;
	}
}
