package com.ddmu.retocp.controller;

import com.ddmu.retocp.domain.model.Product;
import com.ddmu.retocp.domain.repository.ProductRepository;
import com.ddmu.retocp.domain.service.ProductService;
import com.ddmu.retocp.resource.request.ProductRequest;
import com.ddmu.retocp.resource.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/api/products")
public class ProductsController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get all products", description = "Get All products")
    @GetMapping("")
    public Page<ProductResponse> getAllProducts(Pageable pageable) {
        List<ProductResponse> responses = productService.getAllProducts(pageable)
                .stream()
                .map(this::convertEntityToResponse)
                .collect(Collectors.toList());
        return new PageImpl<>(responses, pageable, responses.size());
    }

    @Operation(summary = "Get a product", description = "Get a product by code")
    @GetMapping("/{code}")
    public ProductResponse getProductByCode(@PathVariable Long code) {
        return convertEntityToResponse(productService.getProductByCode(code));
    }

    @Operation(summary = "Create a product", description = "Create a product")
    @PostMapping("")
    public ProductResponse createProduct(@RequestBody @Valid ProductRequest productRequest){
        return convertEntityToResponse(productService.createProduct(convertRequestToEntity(productRequest)));
    }

    @Operation(summary = "Update a product", description = "Update a product")
    @PutMapping("")
    public ProductResponse editProduct(@RequestBody @Valid ProductRequest productRequest){
        Product product = convertRequestToEntity(productRequest);
        return convertEntityToResponse(productService.editProductByCode(productRequest.getCode(), product));
    }

    @Operation(summary = "Delete a product", description = "Delete a product")
    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteProductByCode(@PathVariable Long code) {
        return productService.deleteProduct(code);
    }

    private ProductResponse convertEntityToResponse(Product product) {
        return mapper.map(product, ProductResponse.class);
    }

    private Product convertRequestToEntity(ProductRequest productRequest){
        return mapper.map(productRequest, Product.class);
    }
}

