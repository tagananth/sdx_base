package org.servicedx.dao;

import java.security.InvalidKeyException;

public interface SequenceDao
{
	long getPrimaryKey(Class<?> clazz) throws InvalidKeyException;
}