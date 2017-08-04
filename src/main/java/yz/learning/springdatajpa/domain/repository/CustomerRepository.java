package yz.learning.springdatajpa.domain.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import yz.learning.springdatajpa.domain.entity.Customer;

import java.util.List;

/**
 * @author 袁臻
 * 2017/08/04 13:27
 */
public interface CustomerRepository extends CrudRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
    List<Customer> findAll(Specification<Customer> specification);
}
