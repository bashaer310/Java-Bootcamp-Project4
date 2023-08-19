package com.example.project4.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(columnDefinition = "varchar(4) not null CHECK(status='opened' OR status='finished')")
    private String status;

    @NotNull(message = "Max Price must not be empty")
    @Positive(message ="Max Price must be a positive number" )
    //CHECK(maxPrice>'0')**
    @Column(columnDefinition = "int not null ")
    private Integer maxPrice;


    @NotEmpty(message = "Category must not be empty")
    @Pattern(regexp = "^software engineering$ | ^cyber security$ | ^game programming$ | ^web development$",message = "Category must be one of these: software engineering, game programming, web development, cyber security")
    @Column(columnDefinition = "varchar(25) not null CHECK(category REGEXP '^software engineering$ | ^cyber security$ | ^game programming$ | ^web development$')")
    private String category;

    @Column(columnDefinition = "datetime default CURRENT_TIMESTAMP()")
    private LocalDateTime createdAt;
}
