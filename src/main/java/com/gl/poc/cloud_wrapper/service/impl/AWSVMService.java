package com.gl.poc.cloud_wrapper.service.impl;

import com.gl.poc.cloud_wrapper.dto.VMRequest;
import com.gl.poc.cloud_wrapper.dto.VMResponse;
import com.gl.poc.cloud_wrapper.enums.CloudProvider;
import com.gl.poc.cloud_wrapper.service.VMService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AWSVMService implements VMService {


    @Value("${azure.subscription-id}")
    private String subscriptionId;

    @Override
    public VMResponse createVM(VMRequest request) {
        // Use AWS SDK to create VM
        return new VMResponse("VM created in AWS", request.getVmId());
    }

    @Override
    public VMResponse restartVM(CloudProvider provider, String vmId) {
        // Use AWS SDK to restart VM
        return new VMResponse("VM restarted in AWS", vmId);
    }

    @Override
    public VMResponse getVMStatus(CloudProvider provider, String vmId) {
        // Use AWS SDK to check status
        return new VMResponse("VM status: Running in AWS", vmId);
    }

}
