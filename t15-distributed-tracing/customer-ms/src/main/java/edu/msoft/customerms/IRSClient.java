package edu.msoft.customerms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("irs-ms")
public interface IRSClient {

    @GetMapping("/earnings")
    ResponseEntity<EarningsReport> getEarningsByCustomerId(@RequestParam Long customerId);

}
