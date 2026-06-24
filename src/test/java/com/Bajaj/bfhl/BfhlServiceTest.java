package com.Bajaj.bfhl;

import com.Bajaj.bfhl.dto.BfhlRequest;
import com.Bajaj.bfhl.dto.BfhlResponse;
import com.Bajaj.bfhl.service.BfhlServiceImpl;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BfhlServiceTest {
    BfhlServiceImpl svc = new BfhlServiceImpl();

    @Test
    void testExampleA() {
        BfhlRequest req = new BfhlRequest();
        req.setData(List.of("a", "1", "334", "4", "R", "$"));
        BfhlResponse res = svc.process(req);
        assertTrue(res.isSuccess);
        assertEquals(List.of("1"), res.oddNumbers);
        assertEquals(List.of("334", "4"), res.evenNumbers);
        assertEquals(List.of("A", "R"), res.alphabets);
        assertEquals(List.of("$"), res.specialCharacters);
        assertEquals("339", res.sum);
        assertEquals("Ra", res.concatString);
    }

    @Test
    void testExampleC() {
        BfhlRequest req = new BfhlRequest();
        req.setData(List.of("A", "ABCD", "DOE"));
        BfhlResponse res = svc.process(req);
        assertEquals("0", res.sum);
        assertEquals("EoDdCbAa", res.concatString);
    }
}