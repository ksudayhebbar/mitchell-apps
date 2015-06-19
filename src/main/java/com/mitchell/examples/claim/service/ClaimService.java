package com.mitchell.examples.claim.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mitchell.examples.claim.dto.ClaimRequestService;

public interface ClaimService
{
    public Map<String, String> create(ClaimRequestService requestData);

    public Map<String, String> findById(String id);

    public List<HashMap<String, String>> findall();

    public Map<String, String> delete(String id);

    public List<HashMap<String, String>> findByLossDate(Date date);

    
}
