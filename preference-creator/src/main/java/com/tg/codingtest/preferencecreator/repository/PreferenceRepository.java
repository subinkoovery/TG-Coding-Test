package com.tg.codingtest.preferencecreator.repository;

import com.tg.codingtest.preferencecreator.repository.entity.PreferenceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface to perform DB operations.
 */
@Repository
public interface PreferenceRepository extends CrudRepository<PreferenceEntity, Long> {


    Optional<PreferenceEntity> findByCustomer_Id(Long customerId);

}
