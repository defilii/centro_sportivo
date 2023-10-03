package it.euris.academy.centrosportivo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.euris.academy.centrosportivo.entity.Address;
import it.euris.academy.centrosportivo.entity.Customer;
import it.euris.academy.centrosportivo.service.AddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(AddressController.class)
public class AddressControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AddressService addressService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetOneAddress() throws Exception {

        Long id = 1L;

        Address address = Address
                .builder()
                .id(id)
                .build();

        List<Address> addresses = List.of(address);

        when(addressService.findAll()).thenReturn(addresses);

        mockMvc.perform(MockMvcRequestBuilders.get("/addresses"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(id))
        ;
    }

    @Test
    void shouldGetAddressById() throws Exception {

        Long id = 1L;

        Address address = Address
                .builder()
                .id(id)
                .build();



        when(addressService.findById(id)).thenReturn(address);

        mockMvc.perform(MockMvcRequestBuilders.get("/addresses/{id}", id)).
                andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(id))
        ;
    }

    @Test
    void shouldInsertAnAddress() throws Exception {

        Long id = 1L;

        Address address = Address
                .builder()
                .id(id)
                .build();


        when(addressService.save(any())).thenReturn(address);

        mockMvc.perform(post("/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(address)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(id))
        ;
    }

    @Test
    void shouldGetAddressByCustomerId() throws Exception {

        String firstName = "Mario";
        String lastName = "Rossi";
        Long idCustomer = 1L;
        String taxcode = "1234";

        Customer customer = Customer
                .builder()
                .id(idCustomer)
                .name(firstName)
                .surname(lastName)
                .tax_code(taxcode)
                .build();


        Long id = 1L;

        Address address = Address
                .builder()
                .id(id)
                .customer(customer)
                .build();

        List<Address> addresses = List.of(address);

        when(addressService.findAll()).thenReturn(addresses);


        mockMvc.perform(MockMvcRequestBuilders.get("/addresses/customer/{id}", idCustomer)).
                andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
        ;
    }


}