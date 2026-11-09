package com.ui.pojos;

public class AddressPojo {

	private String companyName;
	private String adddress1;
	private String city;
	private String postCode;
	private String homePhone;
	private String mobilePhone;
	private String addressRef;
	private String state;
	private String coutry;
	
	
	public AddressPojo(String companyName, String adddress1, String city, String postCode, String homePhone,
			String mobilePhone, String addressRef, String state, String coutry) {
		super();
		this.companyName = companyName;
		this.adddress1 = adddress1;
		this.city = city;
		this.postCode = postCode;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.addressRef = addressRef;
		this.state = state;
		this.coutry = coutry;
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public String getAdddress1() {
		return adddress1;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getAddressRef() {
		return addressRef;
	}

	public String getState() {
		return state;
	}

	public String getCoutry() {
		return coutry;
	}

	@Override
	public String toString() {
		return "AddressPojo [companyName=" + companyName + ", adddress1=" + adddress1 + ", city=" + city + ", postCode="
				+ postCode + ", homePhone=" + homePhone + ", mobilePhone=" + mobilePhone + ", addressRef=" + addressRef
				+ ", state=" + state + ", coutry=" + coutry + "]";
	}

	
	
	
}
