package com.Bajaj.bfhl.service;

import com.Bajaj.bfhl.dto.BfhlRequest;
import com.Bajaj.bfhl.dto.BfhlResponse;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class BfhlServiceImpl implements BfhlService {

    private static final String USER_ID     = "Harsainyam_Singh_09012005";
    private static final String EMAIL       = "harsainyam1840.be23@chitkara.edu.in";
    private static final String ROLL_NUMBER = "2310991840";

    @Override
    public BfhlResponse process(BfhlRequest request) {
        List<String> data = request.getData();

        List<String> odds    = new ArrayList<>();
        List<String> evens   = new ArrayList<>();
        List<String> alphas  = new ArrayList<>();
        List<String> specials= new ArrayList<>();
        long numSum = 0;

        for (String item : data) {
            if (isNumber(item)) {
                long val = Long.parseLong(item);
                numSum += val;
                if (val % 2 == 0) evens.add(item);
                else              odds.add(item);
            } else if (isAlpha(item)) {
                alphas.add(item.toUpperCase());
            } else {
                specials.add(item);
            }
        }

        StringBuilder joined = new StringBuilder();
        for (String a : alphas) joined.append(a.toUpperCase());

        String reversed = joined.reverse().toString();
        StringBuilder altCaps = new StringBuilder();
        int capIndex = 0;
        for (char c : reversed.toCharArray()) {
            altCaps.append(capIndex % 2 == 0
                    ? Character.toUpperCase(c)
                    : Character.toLowerCase(c));
            capIndex++;
        }

        BfhlResponse resp = new BfhlResponse();
        resp.isSuccess        = true;
        resp.userId           = USER_ID;
        resp.email            = EMAIL;
        resp.rollNumber       = ROLL_NUMBER;
        resp.oddNumbers       = odds;
        resp.evenNumbers      = evens;
        resp.alphabets        = alphas;
        resp.specialCharacters= specials;
        resp.sum              = String.valueOf(numSum);
        resp.concatString     = altCaps.toString();
        return resp;
    }

    private boolean isNumber(String s) {
        try { Long.parseLong(s); return true; }
        catch (NumberFormatException e) { return false; }
    }

    private boolean isAlpha(String s) {
        return s.chars().allMatch(Character::isLetter);
    }
}
