package edu.msoft.irsms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class EarningsController {

    private final Logger logger = LoggerFactory.getLogger(EarningsController.class);

    @GetMapping("/earnings")
    public ResponseEntity<EarningsReport> getEarningsByCustomerId(@RequestParam Long customerId) {

        EarningsReport result = new EarningsReport(
                List.of(new Earning(customerId, (short) 2021, new BigDecimal("85000.0")),
                        new Earning(customerId, (short) 2020, new BigDecimal("55000.0")),
                        new Earning(customerId, (short) 2019, new BigDecimal("35000.0"))),
                System.getProperty("PID"));

        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        logger.info("Returning earnings from process with id {}", result.getSourcePID());

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
