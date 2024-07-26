package edu.msoft.customerms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class IRSClient {

    private final String irsServiceUrl;

    public IRSClient(@Value("${irs.service-url}") String irsServiceUrl) {
        this.irsServiceUrl = irsServiceUrl;
    }

    public EarningsReport getEarningsByCustomerId(Long customerId) {

        RestClient defaultClient = RestClient.create();

        URI uri = UriComponentsBuilder
                .fromUriString(irsServiceUrl + "/earnings")
                .queryParam("customerId", "{customerId}")
                .buildAndExpand(customerId)
                .toUri();

        return defaultClient.get()
                  .uri(uri).retrieve().body(EarningsReport.class);

    }

}
