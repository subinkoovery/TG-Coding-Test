package com.tg.codingtest.preferencecreator.repository;

import com.tg.codingtest.preferencecreator.repository.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository class to perform DB operation for customer table.
 */
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {


}
