package it.euris.academy.centrosportivo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigInteger;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  CustomerService customerService;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void shouldGetOneCustomer() throws Exception {

    String firstName = "Mario";
    String lastName = "Rossi";

    Customer customer = Customer
        .builder()
        .build();

    List<Customer> customers = List.of(customer);

    when(customerService.findAll()).thenReturn(customers);

    mockMvc.perform(MockMvcRequestBuilders.get("/customer"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(1))
        .andExpect(jsonPath("$[0].firstName").value(firstName))
        .andExpect(jsonPath("$[0].lastName").value(lastName));
  }

  @Test
  void shouldGetCustomerById() throws Exception {

    String firstName = "Mario";
    String lastName = "Rossi";
    BigInteger id = BigInteger.valueOf(1);

    Customer customer = Customer
            .builder()
            .build();

    List<Customer> customers = List.of(customer);

    when(customerService.findById(id)).thenReturn(customer);


    mockMvc.perform(MockMvcRequestBuilders.get("/customers/v1/{id}", id)).
             andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//            .andExpect(jsonPath("$").isArray()) fallirebbe perch[ non array
//            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$.id").value(id))
    ;
  }


  @Test
  void shouldInsertACustomer() throws Exception {

    String firstName = "Mario";
    String lastName = "Rossi";

    Customer customer = Customer
        .builder()
        .build();

    when(customerService.save(any())).thenReturn(customer);

    mockMvc.perform(post("/customer")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(customer)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.firstName").value(firstName))
        .andExpect(jsonPath("$.lastName").value(lastName));
  }




}
