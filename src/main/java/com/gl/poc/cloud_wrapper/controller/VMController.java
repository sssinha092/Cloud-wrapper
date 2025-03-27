package com.gl.poc.cloud_wrapper.controller;

import com.gl.poc.cloud_wrapper.dto.VMRequest;
import com.gl.poc.cloud_wrapper.dto.VMResponse;
import com.gl.poc.cloud_wrapper.enums.CloudProvider;
import com.gl.poc.cloud_wrapper.service.VMServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vm")
public class VMController {

    @Autowired
    private VMServiceFactory vmServiceFactory;


    @PostMapping("/execute")
    public ResponseEntity<?> executeVMAction(@RequestBody VMRequest request) {
        CloudProvider provider = request.getProvider();
        VMResponse response;
        switch (request.getAction()) {
            case "create":
                 response = vmServiceFactory.getVMService(provider).createVM(request);
                return ResponseEntity.ok(response);
            case "restart":
                 response=vmServiceFactory.getVMService(provider).restartVM(provider, request.getVmId());
                return ResponseEntity.ok(response);
            case "status":
                response=vmServiceFactory.getVMService(provider).getVMStatus(provider, request.getVmId());
                return ResponseEntity.ok(response);
            default:
                return ResponseEntity.badRequest().body("Invalid action: " + request.getAction());
        }
    }
}


