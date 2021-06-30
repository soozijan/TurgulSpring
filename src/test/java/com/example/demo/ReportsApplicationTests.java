package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import org.apache.catalina.WebResource;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import static com.example.demo.Utils_java.checkHighwayLegalspeed;
import static com.example.demo.Utils_java.checkUrbanLegalSpeed;

@SpringBootTest
class ReportsApplicationTests {

	@Test
	public void test_highway_speed() {
		int legalSpeed = 60;
		int gvulySpeed = 120;
		int notLegal = 140;

		boolean result = checkHighwayLegalspeed(legalSpeed);
		assert result == true;

		result = checkHighwayLegalspeed(gvulySpeed);
		assert result == true;

		result = checkHighwayLegalspeed(notLegal);
		assert result == false;
	}

	@Test
	public void test_urban_speed(){
		int legalSpeed = 50;
		int gvulySpeed = 90;
		int notLegal = 100;

		boolean result = checkUrbanLegalSpeed(legalSpeed);
		assert  result == true;

		result = checkUrbanLegalSpeed(gvulySpeed);
		assert result ==true;

		result = checkUrbanLegalSpeed(notLegal);
		assert result == false;
	}

}
