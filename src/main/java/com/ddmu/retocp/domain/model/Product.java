package com.ddmu.retocp.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    private Long code;

    @NotBlank
    @Size(max = 200)
    private String name;

    @NotNull
    private Long price;
}
