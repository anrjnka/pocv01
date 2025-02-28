package com.pocv01.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocv01.model.CatalogVendor;
import com.pocv01.model.DataBahan;
import com.pocv01.model.HeaderBahan;
import com.pocv01.model.Menu;
import com.pocv01.model.User;


@Service
public class headerBahanService {
	public static List<HeaderBahan> headerBahan(User session) {
		java.util.List<HeaderBahan> headerBahanList = null;
		 ObjectMapper objectMapper = new ObjectMapper();
		 try {
			 headerBahanList = objectMapper.readValue(new File("D:\\sampingan\\tools\\samplejson\\headerbahantest.json"), new TypeReference<List<HeaderBahan>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return headerBahanList;
	}
}
