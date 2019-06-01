package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Address extends CommonCustomerBean implements IAddress
{
	private static final long	serialVersionUID	= 8258512602150604322L;
	private String				addressLine1		= "Address 1";
	private String				addressLine2;
	private String				addressLine3;
	private String				city				= "Chennai";
	private String				country;
	private String				countryName;
	private String				state;
	private String				stateName;
	private String				zipCode;

	public Address()
	{
		super();
	}

	public Address(String addressLine1, String addressLine2, String addressLine3, String city, String country, String countryName, String state, String stateName, String zipCode)
	{
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.country = country;
		this.countryName = countryName;
		this.state = state;
		this.stateName = stateName;
		this.zipCode = zipCode;
	}

	@Override
	@Column(name = "addressline1")
	public String getAddressLine1()
	{
		return addressLine1;
	}

	@Override
	@Column(name = "addressline2")
	public String getAddressLine2()
	{
		return addressLine2;
	}

	@Override
	@Column(name = "addressline3")
	public String getAddressLine3()
	{
		return addressLine3;
	}

	@Override
	@Column(name = "city")
	public String getCity()
	{
		return city;
	}

	@Override
	@Column(name = "country")
	public String getCountry()
	{
		return country;
	}

	@Override
	@Column(name = "countryname")
	public String getCountryName()
	{
		return countryName;
	}

	@Override
	@Column(name = "state")
	public String getState()
	{
		return state;
	}

	@Override
	@Column(name = "statename")
	public String getStateName()
	{
		return stateName;
	}

	@Override
	@Column(name = "zipcode")
	public String getZipCode()
	{
		return zipCode;
	}

	@Override
	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	@Override
	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	@Override
	public void setAddressLine3(String addressLine3)
	{
		this.addressLine3 = addressLine3;
	}

	@Override
	public void setCity(String city)
	{
		this.city = city;
	}

	@Override
	public void setCountry(String country)
	{
		this.country = country;
	}

	@Override
	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}

	@Override
	public void setState(String state)
	{
		this.state = state;
	}

	@Override
	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	@Override
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

}
