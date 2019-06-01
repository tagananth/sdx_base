package org.servicedx.bean.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Entity
@Table(name = "country")
public class Country implements Serializable, Comparable<Country>
{

	private static final long	serialVersionUID	= 6505907186649651706L;
	private String				country;
	private String				countryName;
	private String				countryCode;
	private boolean				status;

	public Country()
	{
		super();
	}

	@PrimaryKey
	@Column(name = "country")
	public String getCountry()
	{
		return country;
	}

	@Column(name = "countryname")
	public String getCountryName()
	{
		return countryName;
	}

	@Column(name = "status")
	public boolean isStatus()
	{
		return status;
	}

	@Column(name = "countryname")
	public String getCountryCode()
	{
		return countryCode;
	}
	
	public void setStatus(boolean status)
	{
		this.status = status;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}

	public void setCountryCode(String countryCode)
	{
		this.countryCode = countryCode;
	}
	
	@Override
	public int compareTo(Country country)
	{
		return countryName.compareTo(country.getCountryName());
	}

}
