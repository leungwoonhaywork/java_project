package com.sparta.wl.week5;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatesResponse{
	//private List<Rates> ratesList = new ArrayList<>();

	@JsonProperty("date")
	private String date;

	@JsonProperty("success")
	private Boolean success;

	@JsonProperty("rates")
	private Rates rates;

	@JsonProperty("timestamp")
	private Integer timestamp;

	@JsonProperty("base")
	private String base;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setSuccess(Boolean success){
		this.success = success;
	}

	public Boolean isSuccess(){
		return success;
	}

	public void setRates(Rates rates){
		this.rates = rates;
	}

	public Rates getRates() {
		return rates;
	}

	//public List<Rates> getRates(){
	//	return ratesList;
	//}

	public void setTimestamp(Integer timestamp){
		this.timestamp = timestamp;
	}

	public Integer getTimestamp(){
		return timestamp;
	}

	public void setBase(String base){
		this.base = base;
	}

	public String getBase(){
		return base;
	}

	@Override
 	public String toString(){
		return 
			"RatesResponse{" + 
			"date = '" + date + '\'' + 
			",success = '" + success + '\'' + 
			",rates = '" + rates + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			",base = '" + base + '\'' + 
			"}";
		}
}