package com.ddmu.retocp.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

    @NotNull
    @Valid
    @Field(name = "client")
    private Client client;


}
