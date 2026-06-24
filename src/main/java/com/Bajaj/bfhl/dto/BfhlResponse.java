package com.Bajaj.bfhl.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BfhlResponse {
    @JsonProperty("is_success")     public boolean isSuccess;
    @JsonProperty("user_id")        public String userId;
    @JsonProperty("email")          public String email;
    @JsonProperty("roll_number")    public String rollNumber;
    @JsonProperty("odd_numbers")    public List<String> oddNumbers;
    @JsonProperty("even_numbers")   public List<String> evenNumbers;
    @JsonProperty("alphabets")      public List<String> alphabets;
    @JsonProperty("special_characters") public List<String> specialCharacters;
    @JsonProperty("sum")            public String sum;
    @JsonProperty("concat_string")  public String concatString;
}
