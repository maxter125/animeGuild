package com.spring.Ibento.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
public class HourlyScheduler {

    private final String API_URL = "YOUR_API_URL"; // Replace with your API URL

    //@Scheduled(fixedRate = 360) // Run every hour (3600000 milliseconds)
    public void executeHourlyTask() {
        try {
            String publicIp = fetchPublicIp();
            makeApiCall(publicIp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String fetchPublicIp() {
        // Use any method to fetch public IP, here we use a simple REST call
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://api64.ipify.org?format=json", String.class);
        return response.split("\"")[3];
    }

    private void makeApiCall(String publicIp) {
        // Make API call with public IP
        RestTemplate restTemplate = new RestTemplate();
        String payload = "{\"ip\": \"" + publicIp + "\"}";
        restTemplate.postForObject(API_URL, payload, String.class);
        System.out.println("API call successful");
    }
}
