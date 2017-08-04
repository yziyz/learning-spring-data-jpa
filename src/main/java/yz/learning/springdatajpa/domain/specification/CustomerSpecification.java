package yz.learning.springdatajpa.domain.specification;

import org.springframework.data.jpa.domain.Specification;
import yz.learning.springdatajpa.domain.entity.Customer;
import yz.learning.springdatajpa.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;

/**
 * @author 袁臻
 * 2017/08/04 13:31
 */
public class CustomerSpecification {
    public static Specification<Customer> isLongTermCustomer() {
        return (Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Date date = new Date();
            return cb.lessThan(root.get("createdAt"), date);
        };
    }

    public static Specification<Customer> isFirstNameLike(final String name) {
        return (Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> cb.or(cb.like(root.get("firstName"), StringUtils.wildcard(name)));
    }
}
