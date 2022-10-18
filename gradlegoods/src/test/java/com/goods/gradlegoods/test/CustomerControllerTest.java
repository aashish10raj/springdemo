package com.goods.gradlegoods.test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goods.gradlegoods.controller.CustomerController;
import com.goods.gradlegoods.entities.Customer;
import com.goods.gradlegoods.entities.Seller;
import com.goods.gradlegoods.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
	private MockMvc mockMvc;
	
	
	
	@Mock	
	private CustomerService customerservice;
	
	@InjectMocks
	private CustomerController customercontroller;
	
    private ObjectMapper objectMapper = new ObjectMapper();

	
	@SuppressWarnings("deprecation")
	@BeforeEach
	  public void setUp() {
	    MockitoAnnotations.initMocks(this);
	    mockMvc = MockMvcBuilders.standaloneSetup(customercontroller).build();
	    
	}
	
	@Test
	public void testGetExample() throws Exception {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Aashish");
        customer.setExpenditure(123);
        Seller seller = new Seller();
        seller.setId(101);
        seller.setSeller_name("Ganga");
        seller.setEarning(147);
        customers.add(customer);
        when(customerservice.getAllCustomers()).thenReturn(customers);
        String url ="/customers";
       mockMvc.perform(get(url)).andExpect(status().isOk());
        
        verify(customerservice,times(1)).getAllCustomers();
        


    }
	
	@Test
	public void getCustomersBySellerTest() throws Exception {
		Seller s1=new Seller(101, "ganga", 123);
		Customer c1= new Customer(1, "Aashish", 123, s1);
		//Customer c2=new Customer(1,"abhishek", 147, s1);
	//String json = objectMapper.writeValueAsString(c1);
		int sid= 101;
	when(customerservice.getAllCustomersBySellerId(sid)).thenReturn(Arrays.asList(c1));
	
	List<Customer> list = (List<Customer>) customercontroller.getAllCustomersBySellerId(sid);
	assertEquals(1, list.size());
		this.mockMvc.perform(get("/customersbyseller/{id}", sid))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    	        
        ;
		verify(customerservice,times(2)).getAllCustomersBySellerId(101);
////		String url ="/customers";
////		mockMvc.perform(post(url)).andExpect(status().isOk());
//	}

	
	
	}
	
	@Test
	public void insertCustomerPostTest() throws Exception {
		Seller s1=new Seller(101, "ganga", 123);
		Customer c1= new Customer(1, "Aashish", 123, s1);
		//doNothing().when(customerservice).addCustomer(c1);
		customerservice.addCustomer(c1);
		verify(customerservice,times(1)).addCustomer(c1);
//		this.mockMvc.perform(post("/customers"))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType("application/json"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/customers")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(c1));

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.OK.value(), response.getStatus());

	  //  assertEquals("/customers",response.getHeader(HttpHeaders.LOCATION));
	}
}
