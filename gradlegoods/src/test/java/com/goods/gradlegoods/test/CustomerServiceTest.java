package com.goods.gradlegoods.test;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.goods.gradlegoods.data.CustomerData;
import com.goods.gradlegoods.entities.Customer;
import com.goods.gradlegoods.entities.Seller;
import com.goods.gradlegoods.service.CustomerService;
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	


@Mock 
	private CustomerData customerRepository;
	
	@Mock
	private CustomerService customerservice;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	  public void setUp() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test	
	public void getCustomers() {
		Seller s1=new Seller(101, "ganga", 123);
		Customer c1= new Customer(1, "Aashish", 123, s1);
		Customer c2=new Customer(1,"abhishek", 147, s1);
		//System.out.println(Arrays.asList(c1,c2));
		
		when(customerRepository.findAll()).thenReturn(Arrays.asList(c1,c2));
		List<Customer> list =customerservice.getAllCustomers();
		
		//System.out.println(list);
		
		assertNotNull(list);
		
		
	
	
}
	@Test
	public void getCustomersBySellerIdTest()
	{
		int sid=101;
		Seller s1=new Seller(101, "ganga", 123);
		Customer c1= new Customer(1, "Aashish", 123, s1);
		Customer c2=new Customer(1,"abhishek", 147, s1);
		when(customerRepository.findBySellerId(sid)).thenReturn(Arrays.asList(c1,c2));
		
		List<Customer> list=customerservice.getAllCustomersBySellerId(sid);
		
		assertNotNull(list);
		//System.out.println(list);
	}
	
	@Test
	public void addCustomerTest() {
		Seller s1=new Seller(101, "ganga", 123);
		Customer c1= new Customer(1, "Aashish", 123, s1);
		doNothing().when(customerservice).addCustomer(c1);
		customerservice.addCustomer(c1);
		
		verify(customerRepository,times(0)).save(c1);
		
	}
	
	@Captor
	ArgumentCaptor<Customer> customerCaptor;
	
	@Test
	public void isCorrectFormatpassedTest() throws Exception {
		
		Seller s1=new Seller(101, "ganga", 123);
		Customer c1= new Customer(1, "Aashish", 123, s1);
		assertNotNull(c1);
		when(customerRepository.save(c1)).thenReturn(c1);
		customerservice.addCustomer(c1);
		verify(customerservice).addCustomer(c1);
		//test the arguments passed
		verify(customerservice).addCustomer(customerCaptor.capture());
		int customerCaptorValue = customerCaptor.getValue().getId();
		assertEquals(customerCaptorValue, 1); //verify whether the passed value is 1 or not
		
		//throwing exception error while entering wrong data types 
		
		if((Character.isDigit(customerCaptorValue))) {
			throw new Exception("incorrect data type");
		}
	}
	
	
	
}

