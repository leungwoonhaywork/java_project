package com.sparta.wl.week5;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityDTO{

	@JsonProperty("activity")
	private String activity;

	@JsonProperty("accessibility")
	private Integer accessibility;

	@JsonProperty("price")
	private Integer price;

	@JsonProperty("link")
	private String link;

	@JsonProperty("type")
	private String type;

	@JsonProperty("key")
	private String key;

	@JsonProperty("participants")
	private Integer participants;

	public void setActivity(String activity){
		this.activity = activity;
	}

	public String getActivity(){
		return activity;
	}

	public void setAccessibility(Integer accessibility){
		this.accessibility = accessibility;
	}

	public Integer getAccessibility(){
		return accessibility;
	}

	public void setPrice(Integer price){
		this.price = price;
	}

	public Integer getPrice(){
		return price;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	public void setParticipants(Integer participants){
		this.participants = participants;
	}

	public Integer getParticipants(){
		return participants;
	}

	@Override
 	public String toString(){
		return 
			"BoredResponse{" + 
			"activity = '" + activity + '\'' + 
			",accessibility = '" + accessibility + '\'' + 
			",price = '" + price + '\'' + 
			",link = '" + link + '\'' + 
			",type = '" + type + '\'' + 
			",key = '" + key + '\'' + 
			",participants = '" + participants + '\'' + 
			"}";
		}
}