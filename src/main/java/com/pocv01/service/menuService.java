package com.pocv01.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocv01.model.Menu;
import com.pocv01.model.User;


@Service
public class menuService {
	public static List<Menu> menu(User session) {
		java.util.List<Menu> menuList = null;
		 ObjectMapper objectMapper = new ObjectMapper();
		 try {
			 menuList = objectMapper.readValue(new File("D:\\sampingan\\tools\\samplejson\\datamenutest.json"), new TypeReference<List<Menu>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return menuList;
	}
}
