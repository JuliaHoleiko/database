package com.holeiko.database.domain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    private Integer clientId;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

}
