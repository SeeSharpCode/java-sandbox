package com.sandbox.springbootdatarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people") // not required, only used to change "persons" to "people"
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name)        ;
}
