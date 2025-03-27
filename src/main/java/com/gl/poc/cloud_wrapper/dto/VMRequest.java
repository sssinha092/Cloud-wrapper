package com.gl.poc.cloud_wrapper.dto;

import com.gl.poc.cloud_wrapper.enums.CloudProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VMRequest {
    private String action;  // "create", "restart", "status"
    private CloudProvider provider;
    private String vmId;
    private String region;
    private String ram;
    private String cpu;
}