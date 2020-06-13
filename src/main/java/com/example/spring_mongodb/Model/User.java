package com.example.spring_mongodb.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection= "role")
public class User {

    @Id
    private int id;
    private String organization;
    private String firstName;
    private String lastName;
    private String nicNo;
    private String roleType;
}
