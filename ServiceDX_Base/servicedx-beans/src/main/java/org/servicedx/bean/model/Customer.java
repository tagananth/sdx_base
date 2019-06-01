package org.servicedx.bean.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.Authentication;

@Entity
@Table(name = "customer")
public class Customer extends CommonModeBean implements ICustomer ,IAddress
{
	private static final long	serialVersionUID	= 7834148407625900191L;
	protected long				customerId;
	protected String			customerName;
	protected String			addressLine1		= "Address 1";
	protected String			addressLine2;
	protected String			addressLine3;
	protected String			city				= "Chennai";
	protected String			country;
	protected String			countryName;
	protected String			state;
	protected String			stateName;
	protected String			zipCode;

	public Customer()
	{
		super();
	}

	@Column(name = "customerid")
	public long getCustomerId()
	{
		return customerId;
	}

	@Column(name = "customername")
	public String getCustomerName()
	{
		return customerName;
	}

	public void setCustomerId(long customerId)
	{
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
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
	@Override
	protected void customerInfo(Authentication auth)
	{
		// No Need to Implement
	}
}
