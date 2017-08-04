package yz.learning.springdatajpa.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yz.learning.springdatajpa.Application;
import yz.learning.springdatajpa.domain.entity.Customer;
import yz.learning.springdatajpa.domain.repository.CustomerRepository;
import yz.learning.springdatajpa.domain.specification.CustomerSpecification;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.Specifications.where;

/**
 * @author 袁臻
 * 2017/08/04 14:05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestCustomer {
    @Autowired
    private CustomerRepository customerRepository;

    //@Test
    public void testSaveACustomer() {
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString());
        customer.setCreatedAt(new Date());
        customer.setFirstName("Pacer");
        customer.setLastName("Song");

        customerRepository.save(customer);
    }

    @Test
    public void testIsLongTermCustomer() {
        List<Customer> customerList = customerRepository.findAll(CustomerSpecification.isLongTermCustomer());
        customerList.forEach(System.out::println);
    }

    @Test
    public void testIsFirstNameLike() {
        List<Customer> customerList = customerRepository.findAll(CustomerSpecification.isFirstNameLike("ac"));
        customerList.forEach(System.out::println);
    }

    @Test
    public void testIsLongTermCustomerAndIsFirstNamelike() {
        System.out.println("匹配名字的长期用户");
        List<Customer> customerList = customerRepository.findAll(where(CustomerSpecification.isFirstNameLike("ac")).and(CustomerSpecification.isLongTermCustomer()));
        customerList.forEach(System.out::println);
    }
}
