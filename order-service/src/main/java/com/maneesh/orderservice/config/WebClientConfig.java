package com.maneesh.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    /* When we are running multiple instances of application there will be confusion
    * from port it should get the data. So Inorder to tackle that issue we are using client Side
    * Load Balancer. Here with the help of Webclient we are calling Inventory Service
    * Now order service will not get confuse and it calls whatever it want*/
    public WebClient.Builder webClientBuilder(){

        System.out.println("Webclient Called");
        return WebClient.builder();
    }
}
