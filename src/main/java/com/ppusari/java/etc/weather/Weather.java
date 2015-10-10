// http://noritersand.tistory.com/240
	
package com.ppusari.java.etc.weather;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppusari.java.etc.weather.WeatherResponse.Response;
 
 
public class Weather { 
	 
	// 인코딩
	// http://coderstoolbox.net/string/#!encoding=url&action=decode&charset=utf_8
		
	// 회사인증키
	// Y6CGhVoKI0kmtQXjBaE0TKDIiLd7MPnOPTWeONZO2bc%2FtkKPr%2BmBoWUMjoT%2Bz%2FwY1qMFdatdoJC3JGi9rPqb5w%3D%3D
	// Y6CGhVoKI0kmtQXjBaE0TKDIiLd7MPnOPTWeONZO2bc/tkKPr+mBoWUMjoT+z/wY1qMFdatdoJC3JGi9rPqb5w==
	// http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService/ForecastGrib?ServiceKey=Y6CGhVoKI0kmtQXjBaE0TKDIiLd7MPnOPTWeONZO2bc%2FtkKPr%2BmBoWUMjoT%2Bz%2FwY1qMFdatdoJC3JGi9rPqb5w%3D%3D&base_date=20151003&base_time=1000&nx=92&ny=131&_type=json
		
	// 개인 인증키
	// vl1xOQtbethZX1ZYsA66YjiQq3g%2F%2F5pn9SoBsKVtEW1YiyDYCBUJwxr9RtURdu3nhEriuIjpWjKZmGPU9bHMzw%3D%3D
	// vl1xOQtbethZX1ZYsA66YjiQq3g//5pn9SoBsKVtEW1YiyDYCBUJwxr9RtURdu3nhEriuIjpWjKZmGPU9bHMzw==
	// http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService/ForecastGrib?ServiceKey=vl1xOQtbethZX1ZYsA66YjiQq3g%2F%2F5pn9SoBsKVtEW1YiyDYCBUJwxr9RtURdu3nhEriuIjpWjKZmGPU9bHMzw%3D%3D&base_date=20151003&base_time=1000&nx=92&ny=131&_type=json

	
	  
	// 공공데이터를 string json 으로 출력
	public void weather(){
	RestTemplate restTemplate = new RestTemplate();
	 		
		String url = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService/ForecastGrib?ServiceKey={ServiceKey}&base_date={base_date}&base_time={base_time}&nx={nx}&ny={ny}&_type={_type}";
		
		String serviceKey = "vl1xOQtbethZX1ZYsA66YjiQq3g%2F%2F5pn9SoBsKVtEW1YiyDYCBUJwxr9RtURdu3nhEriuIjpWjKZmGPU9bHMzw%3D%3D";		
		try {
			serviceKey = URLDecoder.decode(serviceKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		} 
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("ServiceKey", serviceKey);		
		params.put("base_date", "20151010");		
		params.put("base_time", "0700");
		params.put("nx", "92");
		params.put("ny", "131");
		params.put("_type", "json"); 
 	
 		String result = restTemplate.getForObject(url, String.class, params);		
		System.out.println(result.toString());
	  
	}
	
	// 공공데이터를 string json 으로 출력
	public void weather2(){
		
		RestTemplate restTemplate = new RestTemplate();
	 		
		String serviceKey = "vl1xOQtbethZX1ZYsA66YjiQq3g%2F%2F5pn9SoBsKVtEW1YiyDYCBUJwxr9RtURdu3nhEriuIjpWjKZmGPU9bHMzw%3D%3D";		
		try {
			serviceKey = URLDecoder.decode(serviceKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		} 
		
		URI targetUrl= UriComponentsBuilder.fromUriString("http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService/ForecastGrib")			    
			    .queryParam("ServiceKey", serviceKey)
			    .queryParam("base_date", "20151003")
			    .queryParam("base_time", "1300")
			    .queryParam("nx", "92")
			    .queryParam("ny", "131")
			    .queryParam("_type", "json")			    
			    .build()			    
			    .toUri();
	 
		System.out.println("URL: " + targetUrl.toString());
				
		String result = restTemplate.getForObject(targetUrl, String.class); 
		System.out.println(result.toString());
	}
	 	
	// 공공데이터를 map 으로 출력
	@SuppressWarnings("unchecked")
	public void weather3(){		 
		
		RestTemplate restTemplate = new RestTemplate();
 		
		String url = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService/ForecastGrib?ServiceKey={ServiceKey}&base_date={base_date}&base_time={base_time}&nx={nx}&ny={ny}&_type={_type}";
		
		String serviceKey = "vl1xOQtbethZX1ZYsA66YjiQq3g%2F%2F5pn9SoBsKVtEW1YiyDYCBUJwxr9RtURdu3nhEriuIjpWjKZmGPU9bHMzw%3D%3D";		
		try {
			serviceKey = URLDecoder.decode(serviceKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		} 
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("ServiceKey", serviceKey);		
		params.put("base_date", "20151003");		
		params.put("base_time", "1200");
		params.put("nx", "92");
		params.put("ny", "131");
		params.put("_type", "json");
		
		HashMap<String, Object> api = (HashMap<String, Object>) restTemplate.getForObject(url, HashMap.class, params);	
		HashMap<String, Object> response = (HashMap<String, Object>) api.get("response");		
		HashMap<String, Object> header = (HashMap<String, Object>) response.get("header");
		HashMap<String, Object> body = (HashMap<String, Object>) response.get("body");
				
		String resultMsg = (String)header.get("resultMsg");		
		if (resultMsg.equals("OK")){		
			HashMap<String, Object> items =  (HashMap<String, Object>) body.get("items");
			
			List<HashMap<String, Object>> item = (List<HashMap<String, Object>>) items.get("item");			
			System.out.println("size: " + item.size());
			
			for (HashMap<String, Object> hashMap : item) {
				System.out.println(hashMap.get("category").toString());
				System.out.println(hashMap.get("obsrValue").toString());
			}
		}
		
	}
 	
	// 공공데이터를 string으로 받아서 class에 매핑시키기
	public void weather4(){
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService/ForecastGrib?ServiceKey={ServiceKey}&base_date={base_date}&base_time={base_time}&nx={nx}&ny={ny}&_type={_type}";
		
		String serviceKey = "vl1xOQtbethZX1ZYsA66YjiQq3g%2F%2F5pn9SoBsKVtEW1YiyDYCBUJwxr9RtURdu3nhEriuIjpWjKZmGPU9bHMzw%3D%3D";		
		try {
			serviceKey = URLDecoder.decode(serviceKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
		} 
		
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("ServiceKey", serviceKey);		
		params.put("base_date", "20151003");		
		params.put("base_time", "1200");
		params.put("nx", "92");
		params.put("ny", "131");
		params.put("_type", "json");
		 	
 		String result = restTemplate.getForObject(url, String.class, params);
		System.out.println(result.toString());		
		
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse weatherResponse = null;
		
		try {
			weatherResponse = mapper.readValue(result, WeatherResponse.class); 			
		} catch (JsonParseException e) {			
			e.printStackTrace();
		} catch (JsonMappingException e) {			
			e.printStackTrace(); // items 의 값을 가져오지 못하는군 왜일까?
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		
		Response response = weatherResponse.getResponse();
		
		if (response.getHeader().getResultMsg().equals("OK")){
		 	
/*			List<Item> items = response.getBody().getItems().getItem();
			
			if(items != null) {
				for (Item item : items) {
					
					logger.info(item.getObsrValue());
					
				}
			}*/
		}
		else{
			System.out.println("weather response result msg: " + response.getHeader().getResultMsg());		
			System.out.println("weather response result code: " + response.getHeader().getResultCode());
		}
	}
	
 
	
}

 


