package com.Bajaj.bfhl.service;

import com.Bajaj.bfhl.dto.BfhlRequest;
import com.Bajaj.bfhl.dto.BfhlResponse;

public interface BfhlService {
    BfhlResponse process(BfhlRequest request);
}
