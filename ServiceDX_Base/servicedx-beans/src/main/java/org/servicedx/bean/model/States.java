package org.servicedx.bean.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Entity
@Table(name = "states")
public class States implements Serializable, Comparable<States>
{

	private static final long	serialVersionUID	= 4766643355674843027L;
	private String				country;
	private String				state;
	private String				stateName;
	private boolean				status;

	public States()
	{
		super();
	}

	@Column(name = "country")
	public String getCountry()
	{
		return country;
	}

	@PrimaryKey
	@Column(name = "state")
	public String getState()
	{
		return state;
	}

	@Column(name = "statename")
	public String getStateName()
	{
		return stateName;
	}

	@Column(name = "status")
	public boolean isStatus()
	{
		return status;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public void setStateName(String stateName)
	{
		this.stateName = stateName;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	@Override
	public int compareTo(States state)
	{
		return this.stateName.compareTo(state.getStateName());
	}

}
