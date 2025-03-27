package com.gl.poc.cloud_wrapper.service;

import com.gl.poc.cloud_wrapper.dto.VMRequest;
import com.gl.poc.cloud_wrapper.dto.VMResponse;
import com.gl.poc.cloud_wrapper.enums.CloudProvider;

public interface VMService {
    VMResponse createVM(VMRequest request);

    VMResponse restartVM(CloudProvider provider, String vmId);

    VMResponse getVMStatus(CloudProvider provider, String vmId);
}
