package com.ui.utilities;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPojo;

public class FakeAddressUtiltiy {
	
	public static AddressPojo getAddress() {
		
		Faker faker = new Faker(Locale.US);
		
		AddressPojo address = new AddressPojo(faker.company().name(),faker.address().buildingNumber(), faker.address().city(), faker.numerify("#####"), faker.phoneNumber().cellPhone(),faker.phoneNumber().cellPhone(), faker.address().streetAddress(), faker.address().state(), faker.address().country());
		
		return address;
	}
	

}
