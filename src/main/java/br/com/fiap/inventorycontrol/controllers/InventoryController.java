package br.com.fiap.inventorycontrol.controllers;

import br.com.fiap.inventorycontrol.controllers.jsons.request.ProductRequestJson;
import br.com.fiap.inventorycontrol.controllers.jsons.response.ProductResponseJson;
import br.com.fiap.inventorycontrol.domains.Product;
import br.com.fiap.inventorycontrol.usecases.InventoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
@Slf4j
public class InventoryController {

  private InventoryService inventoryService;

  @ApiOperation(value = "Creating a new product")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = "Successfully created product"),
        @ApiResponse(
            code = 400,
            message = "There was an error creating the product, check the information"),
        @ApiResponse(code = 403, message = "Unauthorized access! Authenticate your user")
      })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProductResponseJson create(@RequestBody @Valid final ProductRequestJson productJson) {
    log.info("Creating a new product:: {}", productJson);
    final Product product = productJson.convertJsonToEntity();
    return inventoryService.createOrUpdate(product);
  }

  @ApiOperation(value = "Searching product")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully found product"),
        @ApiResponse(code = 404, message = "Product not found with this id")
      })
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<ProductResponseJson> getById(@PathVariable String id) {
    log.info("Searching product by ID:: {}", id);
    return inventoryService.findBy(id);
  }

  @ApiOperation(value = "List all products")
  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public List<ProductResponseJson> getAll() {
    log.info("List all products.");
    return inventoryService.getAll();
  }

  @ApiOperation(value = "Updating product")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Successfully update product"),
        @ApiResponse(
            code = 400,
            message = "There was an error updating the product, check the information"),
        @ApiResponse(code = 404, message = "Product not found with this id")
      })
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ProductResponseJson update(
      @PathVariable String id, @RequestBody @Valid final ProductRequestJson productJson) {
    log.info("Updating product with ID:: {}", id);
    final Product product = productJson.convertJsonToEntity().withId(id);
    return inventoryService.createOrUpdate(product);
  }

  @ApiOperation(value = "Deleting product")
  @ApiResponses(
      value = {
        @ApiResponse(code = 204, message = "Successfully deleted product"),
        @ApiResponse(code = 404, message = "Product not found with this id")
      })
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Object> deleteById(@PathVariable String id) {
    log.info("Deleting product with ID:: {}", id);
    return inventoryService.deleteById(id);
  }
}
