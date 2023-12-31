package com.example.project4.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message = "Customer Id must not be empty")
    @Column(columnDefinition = "int not null")
    private Integer customerId;

    @NotEmpty(message = "Title must not be empty")
    @Size(min = 10, message = "Title length must be more than 10")
    @Column(columnDefinition = "varchar(50) not null CHECK(LENGTH(title)>=10)")
    private String title;

    @NotEmpty(message = "Description must not be empty")
    @Size(min = 20, message = "Description length must be more than 20")
    @Column(columnDefinition = "varchar(150) not null CHECK(LENGTH(description)>=20)")
    private String description;

    @NotEmpty(message = "Status must not be empty")
    @Pattern(regexp = "opened|finished")
    @Column(columnDefinition = "varchar(8) not null CHECK(status='opened' OR status='finished')")
    private String status;

    @NotNull(message = "Max Price must not be empty")
    @Positive(message ="Max Price must be a positive number" )
    //CHECK(maxPrice>'0')**
    @Column(columnDefinition = "int UNSIGNED not null")
    private Integer maxPrice;


    @NotEmpty(message = "Category must not be empty")
    @Pattern(regexp = "web|apps|gaming",message = "Category must be one of these: apps development, game programming, web development")
    @Column(columnDefinition = "varchar(25) not null CHECK(category REGEXP 'web|apps|gaming')")
    private String category;

    @Column(columnDefinition = "DATE default CURRENT_DATE()")
    private LocalDate createdAt;
}
