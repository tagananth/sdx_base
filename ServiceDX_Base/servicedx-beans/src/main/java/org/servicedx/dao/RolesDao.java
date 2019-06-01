package org.servicedx.dao;

import org.servicedx.bean.model.Roles;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDao extends CassandraRepository<Roles, String>
{

}
