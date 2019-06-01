package org.servicedx.bean.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface ICommonBeanFields extends Serializable
{
	long getCreatedBy();

	String getCreatedByName();

	long getModifiedBy();

	String getModifiedByName();

	void setCreatedBy(long createdBy);

	void setCreatedByName(String createdByName);

	void setModifiedBy(long modifiedBy);

	void setModifiedByName(String modifiedByName);

	LocalDateTime getCreatedDate();

	LocalDateTime getModifiedDate();

	boolean isStatus();

	void setCreatedDate(LocalDateTime createdDate);

	void setModifiedDate(LocalDateTime modifiedDate);

	void setStatus(Boolean status);
}