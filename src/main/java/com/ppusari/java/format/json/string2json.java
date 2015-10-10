// lib에서 java-json.jar 파일이 필요함.

package com.ppusari.java.format.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class string2json {

	public static void main(String[] args) {
		
		StringToJson sj = new StringToJson();
		sj.test1();
		sj.test2();
		sj.test3();
		sj.test4();
	}
}

class StringToJson {

	public void test1() {
		try {
			String str = "{ \"id\" : \"ppusari\", \"pw\" : \"1234\"}";

			JSONObject json = new JSONObject(str);

			String id = json.getString("id");
			String pw = json.getString("pw");
			System.out.println("id: " + id + " pw: " + pw);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void test2() {
		try {
			String str = "{ 'id' : 'ppusari', 'pw' : '1234'}";
			str = str.replace("'", "\"");

			JSONObject json = new JSONObject(str);

			String id = json.getString("id");
			String pw = json.getString("pw");
			System.out.println("id: " + id + " pw: " + pw);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public void test3() {
		try {

			JSONObject json = new JSONObject();
			json.put("id", "ppusari");
			json.put("pw", "1234");

			String id = json.getString("id");
			String pw = json.getString("pw");
			System.out.println("id: " + id + " pw: " + pw);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	public void test4() {
		try {
/*			{ 
				'id' : 'ppusari', 
				'pw' : '1234',
				'Input' : {
					'Url' : 'http://www.naver.com'
				},
				'Outputs' : [
					{
						'Key' : 'filename',
						'PresetId' : 'webm'
					},
					{
						'Key' : 'filename2',
						'PresetId' : 'h264',
						'Captions' : 'test.smi'
					}
				]
			}*/
			String str = "{ 'id' : 'ppusari', 'pw' : '1234', 'Input' : { 'Url' : 'http://www.naver.com' }, 'Outputs' : [ { 'Key' : 'filename', 'PresetId' : 'webm' }, { 'Key' : 'filename2', 'PresetId' : 'h264', 'Captions' : 'test.smi' } ] }";
			str = str.replace("'", "\"");
					
			JSONObject json = new JSONObject(str);

			// 오브젝트 안에 오브젝트 뽑아오기
			JSONObject inputObj = json.getJSONObject("Input");
			String url = inputObj.getString("Url"); 
			System.out.println("value: " + url);
			
			// 오브젝트 안에서 배열 뽑아오기
			JSONArray outputs = json.getJSONArray("Outputs");
			for (int i=0; i<outputs.length(); i++){
				JSONObject obj = outputs.getJSONObject(i);
				String key = obj.getString("Key");
				System.out.println("Key: " + key);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}


