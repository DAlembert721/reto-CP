package com.ddmu.retocp.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    @Indexed(unique = true)
    @NotNull
    private Long orderNumber;

    @DBRef
    private Product product;


    @NotNull
    private Integer quantity;


    @DBRef
    private User client;


}
