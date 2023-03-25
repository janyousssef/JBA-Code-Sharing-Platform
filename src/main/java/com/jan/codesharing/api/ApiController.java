package com.jan.codesharing.api;

import com.jan.codesharing.code.CodeSnippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ApiController {
    @GetMapping("/code")
    public ResponseEntity<?> hello() {
        CodeSnippet codeSnippet = new CodeSnippet("""
                public static void main(String[] args) {
                   \s
                }
                """);
        return new ResponseEntity<>(codeSnippet, HttpStatus.OK);
    }


}
