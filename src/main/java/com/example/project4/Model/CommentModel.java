package com.example.project4.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
public class CommentModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Project Id must not be empty")
    @Column(columnDefinition = "int not null")
    private Integer projectId;

    @NotNull(message = "Expert Id must not be empty")
    @Column(columnDefinition = "int not null")
    private Integer expertId;

    @NotEmpty(message = "Comment must not be empty")
    @Size(min = 10, message = "Comment length must be more than 10")
    @Column(columnDefinition = "varchar(150) not null CHECK(LENGTH(comment)>=10)")
    private String comment;

    @NotNull(message = "Min Price must not be empty")
    @Positive(message ="Min Price must be a positive number" )
    //CHECK(min_price>=0)**
    @Column(columnDefinition = "int UNSIGNED not null")
    private Integer minPrice;

    @Column(columnDefinition = "DATE default CURRENT_DATE()")
    private LocalDate createdAt;
}
