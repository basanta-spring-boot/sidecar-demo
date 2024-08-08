package com.javatechie.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class LoggingService {

    private static final String LOG_FILE_PATH = "/logs/book-service.log";

    @Scheduled(fixedRate = 60000) // Run every minute
    public void processLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Simulate pushing logs to a centralized system
                System.out.println("Processing log: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
