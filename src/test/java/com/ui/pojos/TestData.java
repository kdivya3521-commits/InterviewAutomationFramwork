package com.ui.pojos;

import java.util.List;

public class TestData {
	
	private List<User> data;

	public List<User> getData() {
		return data;
	}

	public void setData(List<User> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TestData [Data=" + data + "]";
	}
	
	

}
