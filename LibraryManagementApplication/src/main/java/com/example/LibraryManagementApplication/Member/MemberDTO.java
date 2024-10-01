package com.example.LibraryManagementApplication.Member;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MemberDTO {

    @JsonProperty("member_name")
    public String memberName;

    @JsonProperty("email")
    public String email;

    @JsonProperty("phone_number")
    public String phoneNumber;

}
