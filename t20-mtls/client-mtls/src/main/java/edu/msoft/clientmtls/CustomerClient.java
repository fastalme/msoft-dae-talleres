package edu.msoft.clientmtls;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "customer-ms", url = "https://localhost", configuration = CustomerClientConfiguration.class)
public interface CustomerClient {

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers();

}
