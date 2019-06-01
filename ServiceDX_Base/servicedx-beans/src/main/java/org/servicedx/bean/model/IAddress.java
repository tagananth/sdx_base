package org.servicedx.bean.model;

public interface IAddress
{

	String getAddressLine1();

	String getAddressLine2();

	String getAddressLine3();

	String getCity();

	String getCountry();

	String getCountryName();

	String getState();

	String getStateName();

	String getZipCode();

	void setAddressLine1(String addressLine1);

	void setAddressLine2(String addressLine2);

	void setAddressLine3(String addressLine3);

	void setCity(String city);

	void setCountry(String country);

	void setCountryName(String countryName);

	void setState(String state);

	void setStateName(String stateName);

	void setZipCode(String zipCode);

}