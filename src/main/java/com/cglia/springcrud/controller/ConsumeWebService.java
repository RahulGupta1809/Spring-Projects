package com.cglia.springcrud.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ConsumeWebService {

    private static final Logger logger =
            LoggerFactory.getLogger(ConsumeWebService.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/template/customers")
    public String getCustomerList() {

        logger.info("Received request to fetch customer list");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "http://192.168.60.39:8085/api/viewcustomers";

        try {
            logger.debug("Calling external service URL: {}", url);

            String response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    String.class
            ).getBody();

            logger.info("Successfully fetched customer list");
            logger.debug("Response received: {}", response);

            return response;

        } catch (Exception e) {
            logger.error("Error while calling external customer service", e);
            throw e;
        }
    }
}
