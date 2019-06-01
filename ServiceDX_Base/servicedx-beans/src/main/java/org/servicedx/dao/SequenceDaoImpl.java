package org.servicedx.dao;

import java.security.InvalidKeyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SequenceDaoImpl implements SequenceDao
{
	@Autowired
	PrimaryDao primaryDao;

	@Override
	public long getPrimaryKey(Class<?> clazz) throws InvalidKeyException
	{
		long primaryId = primaryDao.findByTableName(clazz.getSimpleName());
		if (primaryId > 0L)
		{
			primaryId = primaryId + 1;
			primaryDao.updateSequenceIdByOne(primaryId, clazz.getSimpleName());
			return primaryId;
		}
		throw new InvalidKeyException("Sequence Id NOT received for " + clazz.getSimpleName());
	}
}
