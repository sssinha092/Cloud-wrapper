package com.gl.poc.cloud_wrapper.service;

import com.gl.poc.cloud_wrapper.enums.CloudProvider;
import com.gl.poc.cloud_wrapper.service.impl.AWSVMService;
import com.gl.poc.cloud_wrapper.service.impl.AzureVMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VMServiceFactory {

    @Autowired
    private AzureVMService azureVMService;

    @Autowired
    private AWSVMService awsVMService;


    public VMService getVMService(CloudProvider provider) {
        switch (provider) {
            case AZURE:
                return azureVMService;
            case AWS:
                return awsVMService;
            default:
                throw new IllegalArgumentException("Unsupported provider: " + provider);
        }
    }
}
