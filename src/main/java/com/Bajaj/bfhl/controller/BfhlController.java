package com.Bajaj.bfhl.controller;
import com.Bajaj.bfhl.dto.BfhlRequest;
import com.Bajaj.bfhl.dto.BfhlResponse;
import com.Bajaj.bfhl.service.BfhlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    private final BfhlService service;
    public BfhlController(BfhlService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<BfhlResponse> handle(@RequestBody BfhlRequest request) {
        return ResponseEntity.ok(service.process(request));
    }
}
