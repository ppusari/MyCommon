/*필요한 라이브러리는 다음과 같습니다.
compile 'com.navercorp.volleyextensions:volleyer:2.0.+'
compile 'com.mcxiaoke.volley:library:1.0.+'
compile 'com.fasterxml.jackson.core:jackson-databind:2.6.+'
*/

package com.ppusari.java.etc.weather;
 

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherResponse {
	
	//@JsonProperty("name") // 이름이 같을 때는 굳이 안 써도 된다.	
	
	public Response response;
	
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}

	public class Response {
		
		private Header header;		
		private Body body; 
		
		public Header getHeader() {
			return header;
		}
		public void setHeader(Header header) {
			this.header = header;
		}
 		public Body getBody() {
			return body;
		}
		public void setBody(Body body) {
			this.body = body;
		}

		public class Header {
			
			private String resultCode;
			private String resultMsg;
			
			public String getResultCode() {
				return resultCode;
			}
			public void setResultCode(String resultCode) {
				this.resultCode = resultCode;
			}
			public String getResultMsg() {
				return resultMsg;
			}
			public void setResultMsg(String resultMsg) {
				this.resultMsg = resultMsg;
			} 
		}
					 			
		public class Body {
			
			private Items items;
			private String numOfRows;
			private String pageNo;
			private String totalCount;
						
			public Items getItems() {
				return items;
			}
			public void setItems(Items items) {
				this.items = items;
			}			
			public String getNumOfRows() {
				return numOfRows;
			}
			public void setNumOfRows(String numOfRows) {
				this.numOfRows = numOfRows;
			}
			public String getPageNo() {
				return pageNo;
			}
			public void setPageNo(String pageNo) {
				this.pageNo = pageNo;
			}
			public String getTotalCount() {
				return totalCount;
			}
			public void setTotalCount(String totalCount) {
				this.totalCount = totalCount;
			}
 
			public class Items {
 				
				private List<Item> item;				
				public List<Item> getItem() {
					return item;
				} 
				public void setItem(List<Item> item) {
					this.item = item;
				}
 				
				public class Item {
					
 					private String baseDate;
					private String baseTime;
					private String category;
					private String nx;
					private String ny;
					private String obsrValue;
					
					public String getBaseDate() {
						return baseDate;
					}
					public void setBaseDate(String baseDate) {
						this.baseDate = baseDate;
					}
					public String getBaseTime() {
						return baseTime;
					}
					public void setBaseTime(String baseTime) {
						this.baseTime = baseTime;
					}
					public String getCategory() {
						return category;
					}
					public void setCategory(String category) {
						this.category = category;
					}
					public String getNx() {
						return nx;
					}
					public void setNx(String nx) {
						this.nx = nx;
					}
					public String getNy() {
						return ny;
					}
					public void setNy(String ny) {
						this.ny = ny;
					}
					public String getObsrValue() {
						return obsrValue;
					}
					public void setObsrValue(String obsrValue) {
						this.obsrValue = obsrValue;
					}
				}
			}		
		}
		 
	}

 
	
	
	
}
