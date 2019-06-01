package org.servicedx.dao;

import org.servicedx.bean.model.Sequence;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryDao extends CassandraRepository<Sequence, String>
{
	@Query("select sequenceid from sequence where tablename = ?0")
	long findByTableName(String tableName);

	@Modifying
	@Query("update sequence set sequenceid = ?0 where tablename = ?1")
	void updateSequenceIdByOne(long sequenceId, String clazzName);
}
