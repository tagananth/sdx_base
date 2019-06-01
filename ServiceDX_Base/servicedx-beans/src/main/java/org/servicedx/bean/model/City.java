package org.servicedx.bean.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Entity
@Table(name = "cities")
public class City implements Serializable, Comparable<City>
{

	private static final long	serialVersionUID	= 3432894599006955455L;

	private String				autoId;
	private String				city;
	private String				state;
	private String 				zipCode;
	private boolean				status;

	public City()
	{
		super();
	}

	@PrimaryKey
	@Column(name = "autoid")
	public String getAutoId()
	{
		return autoId;
	}

	@Column(name = "city")
	public String getCity()
	{
		return city;
	}

	@Column(name = "state")
	public String getState()
	{
		return state;
	}

	@Column(name = "status")
	public boolean isStatus()
	{
		return status;
	}

	@Column(name = "zipcode")
	public String getZipCode()
	{
		return zipCode;
	}
	
	public void setAutoId(String autoId)
	{
		this.autoId = autoId;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	
	@Override
	public int compareTo(City city)
	{
		return this.city.compareTo(city.getCity());
	}

}
