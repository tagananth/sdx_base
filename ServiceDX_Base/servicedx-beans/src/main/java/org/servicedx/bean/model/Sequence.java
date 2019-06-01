package org.servicedx.bean.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Sequence implements Serializable
{
	private static final long	serialVersionUID	= 1696926036927427862L;

	private long				sequenceId;
	private String				tableName;

	public Sequence()
	{
		super();
	}

	public Sequence(long sequenceId, String tableName)
	{
		super();
		this.sequenceId = sequenceId;
		this.tableName = tableName;
	}

	@Id
	@Column(name = "sequenceid")
	public long getSequenceId()
	{
		return sequenceId;
	}

	@Column(name = "tablename")
	public String getTableName()
	{
		return tableName;
	}

	public void setSequenceId(long sequenceId)
	{
		this.sequenceId = sequenceId;
	}

	public void setTableName(String tableName)
	{
		this.tableName = tableName;
	}

}
