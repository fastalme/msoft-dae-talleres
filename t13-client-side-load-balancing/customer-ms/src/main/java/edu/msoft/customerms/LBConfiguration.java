package edu.msoft.customerms;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("random-cslb")
@Configuration
@LoadBalancerClient(value = "irs-ms", configuration = CustomLoadBalancerConfiguration.class)
public class LBConfiguration {
}
