package br.com.mba.inventorycontrol.controller;

import br.com.mba.inventorycontrol.model.product.Product;
import br.com.mba.inventorycontrol.model.product.ProductRequestDto;
import br.com.mba.inventorycontrol.model.product.ProductResponseDto;
import br.com.mba.inventorycontrol.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
@Slf4j
public class InventoryController {

  private ProductService productService;

  @ApiOperation(value = "Creating a new product")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Successfully created product"),
      @ApiResponse(code = 400, message = "There was an error creating the product, check the information")
  })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Product create(@RequestBody @Valid final ProductRequestDto productDto) {
    log.info("Creating a new product:: {}", productDto);
    return productService.create(productDto);
  }

  @ApiOperation(value = "Searching product")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully found product"),
      @ApiResponse(code = 404, message = "Product not found with this id")
  })
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ProductResponseDto> getById(@PathVariable Integer id) {
    log.info("Searching product by ID:: {}", id);
    return productService.findById(id);
  }
}
