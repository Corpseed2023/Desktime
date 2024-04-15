package com.example.desktime.controller;

import com.example.desktime.requestDTO.DailyActivityRequest;
import com.example.desktime.responseDTO.DailyActivityResponse;
import com.example.desktime.service.DailyActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.format.DateTimeParseException;

@RestController
public class DailyActivityController {

    @Autowired
    private DailyActivityService dailyActivityService;


    @PostMapping("/saveDailyActivity")
    public ResponseEntity<?> saveDailyActivity(@RequestBody DailyActivityRequest request) {
        try {
            // No need to parse LocalDate again, it's already a LocalDate object
            DailyActivityResponse response = dailyActivityService.saveDailyActivity(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>("Invalid date format. Please provide the date in yyyy-MM-dd format.", HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
