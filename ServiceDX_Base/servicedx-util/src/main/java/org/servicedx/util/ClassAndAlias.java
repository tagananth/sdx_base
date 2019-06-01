package org.servicedx.util;

import java.io.Serializable;

public class ClassAndAlias implements Serializable
{
	private static final long	serialVersionUID	= -3955023046971352393L;
	Class<?>					clazz;
	String						alias;

	public Class<?> getClazz()
	{
		return clazz;
	}

	public void setClazz(Class<?> clazz)
	{
		this.clazz = clazz;
	}

	public String getAlias()
	{
		return alias;
	}

	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	public ClassAndAlias(Class<?> clazz, String alias)
	{
		super();
		this.clazz = clazz;
		this.alias = alias;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassAndAlias other = (ClassAndAlias) obj;
		if (clazz == null)
		{
			if (other.clazz != null)
				return false;
		}
		else if (!clazz.getCanonicalName().equals(other.clazz.getCanonicalName()) && !alias.equals(other.alias))
			return false;
		return true;
	}
}