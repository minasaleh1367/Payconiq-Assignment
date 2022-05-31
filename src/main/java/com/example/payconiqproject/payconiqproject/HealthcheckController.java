package com.example.payconiqproject.payconiqproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
class HealthcheckController {

    // Your solution

    @GetMapping(value = "/healthcheck", produces = "application/json")
    public ResponseEntity<ResultDTO> healthcheck(@RequestParam String format) {

        ResultDTO resultDTO;
        if (format.equals("short")) {
            resultDTO = HealthCheckService.returnShortFormat();
            return new ResponseEntity(resultDTO, HttpStatus.OK);
        } else if (format.equals("full")) {
            resultDTO = HealthCheckService.returnFullFormat();
            return new ResponseEntity(resultDTO, HttpStatus.OK);
        } else
            return new ResponseEntity(HttpStatus.FORBIDDEN);

    }

    @PutMapping(value = "/healthcheck")
    public ResponseEntity<ResultDTO> healthcheckPut() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }

    @PostMapping(value = "/healthcheck")
    public ResponseEntity<ResultDTO> healthcheckPost() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);

    }


    @DeleteMapping(value = "/healthcheck")
    public ResponseEntity<ResultDTO> healthcheckDelete() {
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);

    }

    static class HealthCheckService {
        public static ResultDTO returnShortFormat() {
            return new ResultDTO("OK");
        }

        public static ResultDTO returnFullFormat() {
            return new ResultDTO( "OK",new Date().toString());
        }
    }

    static class ResultDTO {
        private String status;
        private String currentTime;

        public ResultDTO() {
        }

        public ResultDTO(String status) {
            this.status = status;
        }

        public ResultDTO( String status,String currentTime) {
            this.status = status;
            this.currentTime = currentTime;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public String getCurrentTime() {
            return currentTime;
        }
    }


}
