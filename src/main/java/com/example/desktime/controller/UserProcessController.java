package com.example.desktime.controller;


import com.example.desktime.requestDTO.UserProcessRequest;
import com.example.desktime.responseDTO.UserProcessResponse;
import com.example.desktime.service.UserProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeParseException;

@RestController
public class UserProcessController {

    @Autowired
    private UserProcessService userProcessService;

    @PostMapping("/saveUserProcess")
    public ResponseEntity<?> saveUserProcess(@RequestBody UserProcessRequest userProcessRequest) {
        try {
            UserProcessResponse userProcessResponse = userProcessService.saveUserProcess(userProcessRequest);
            return new ResponseEntity<>(userProcessResponse, HttpStatus.OK);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>("Invalid date format. Please provide the date in yyyy-MM-dd format.", HttpStatus.BAD_REQUEST);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
