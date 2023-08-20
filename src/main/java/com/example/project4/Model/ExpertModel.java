package com.example.project4.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExpertModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "Name must be not empty")
    @Size(min = 3,message = "Name length must be more than 3")
    @Column(columnDefinition = "varchar(12) not null CHECK(LENGTH(name)>=3)")
    private String name;

    @NotEmpty(message = "Username must not be empty")
    @Size(min = 4,message = "Username length must be more than 4")
    //@UniqueElements(message = "Username must be unique")
    @Column(columnDefinition = "varchar(15) unique not null CHECK(LENGTH(username)>=4)")
    private String username;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be a valid format")
    //@UniqueElements(message = "Email must be unique")
    @Column(columnDefinition = "varchar(30) unique not null CHECK(email REGEXP '([a-zA-Z0-9]{6,})(@)([a-zA-Z]{6,})(\\.)([a-zA-Z]{2,})')")
    private String email;

    @NotEmpty(message = "Password must not be empty")
    @Size(min = 8, message = "Password length must be more than 8")
    @Pattern(regexp = "(.+)(\\d+)(\\d|.)*|(\\d+)(.+)(\\d|.)*", message = "Password must be contains characters and digits")
    @Column(columnDefinition = "varchar(30) not null CHECK(password REGEXP '(.+)(\\d+)(\\d|.)*|(\\d+)(.+)(\\d|.)*' AND LENGTH(password)>=4)")
    private String password;

    @NotEmpty(message = "Major must not be empty")
    @Pattern(regexp = "^software engineering$ | ^cyber security$ | ^game programming$ | ^web development$",message = "Major must be one of these: software engineering, game programming, web development, cyber security")
    @Column(columnDefinition = "varchar(25) not null CHECK(major REGEXP '^software engineering$ | ^cyber security$ | ^game programming$ | ^web development$')")
    private String major;

    @NotEmpty(message = "Profile must not be empty")
    @Size(min = 10, message = "Profile length must be more than 10")
    @Column(columnDefinition = "varchar(150) not null CHECK(LENGTH(profile)>=10)")
    private String profile;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP()")
    private LocalDateTime createdAt;

}
