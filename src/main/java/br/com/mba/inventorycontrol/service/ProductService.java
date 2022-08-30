package br.com.mba.inventorycontrol.service;

import br.com.mba.inventorycontrol.model.address.Address;
import br.com.mba.inventorycontrol.model.category.Category;
import br.com.mba.inventorycontrol.model.product.Product;
import br.com.mba.inventorycontrol.model.product.ProductRequestDto;
import br.com.mba.inventorycontrol.model.product.ProductResponseDto;
import br.com.mba.inventorycontrol.model.productin.ProductIn;
import br.com.mba.inventorycontrol.model.storageplace.StoragePlace;
import br.com.mba.inventorycontrol.model.storageplace.StoragePlaceRequestDto;
import br.com.mba.inventorycontrol.model.supplier.Supplier;
import br.com.mba.inventorycontrol.repository.AddressRepository;
import br.com.mba.inventorycontrol.repository.CategoryRepository;
import br.com.mba.inventorycontrol.repository.ProductInRepository;
import br.com.mba.inventorycontrol.repository.ProductRepository;
import br.com.mba.inventorycontrol.repository.StoragePlaceRepository;
import br.com.mba.inventorycontrol.repository.SupplierRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

  private ProductRepository productRepository;
  private CategoryRepository categoryRepository;
  private SupplierRepository supplierRepository;
  private StoragePlaceRepository storagePlaceRepository;
  private AddressRepository addressRepository;
  private ProductInRepository productInRepository;

  public Product create(final ProductRequestDto productDto) {
    final Category categorySave = getCategory(productDto);

    final Supplier supplierSave = getSupplier(productDto);

    List<StoragePlace> storagePlacesSave = getStoragePlaces(productDto);

    Product product = productDto.convertJsonToEntity();
    product.setCategory(categorySave);
    product.setSupplier(supplierSave);
    product.setStoragePlaces(storagePlacesSave);

    final Product productSave = productRepository.save(product);
    final ProductIn productIn = ProductIn.builder()
        .idProduct(productSave.getId())
        .quantity(product.getQuantity())
        .build();
    productInRepository.save(productIn);
    return productSave;
  }

  private List<StoragePlace> getStoragePlaces(final ProductRequestDto productDto) {
    final List<StoragePlaceRequestDto> storagePlaces = productDto.getStoragePlaces();
    final List<StoragePlace> storagePlaceList = storagePlaces.stream()
        .map(StoragePlaceRequestDto::convertJsonToEntity)
        .collect(Collectors.toList());

    List<StoragePlace> storagePlacesSave = new ArrayList<>();
    storagePlaceList.forEach(storagePlace -> {
      Address addressSave = addressRepository.save(storagePlace.getAddress());
      storagePlace.setAddress(addressSave);
      storagePlacesSave.add(storagePlaceRepository.save(storagePlace));
    });
    return storagePlacesSave;
  }

  private Supplier getSupplier(final ProductRequestDto productDto) {
    final Supplier supplier = productDto.getSupplier().convertJsonToEntity();
    return supplierRepository.save(supplier);
  }

  private Category getCategory(final ProductRequestDto productDto) {
    final Category category = productDto.getCategory().convertJsonToEntity();
    return categoryRepository.save(category);
  }

  public ResponseEntity<ProductResponseDto> findById(final Integer id) {
    return productRepository.findById(id)
        .map(product -> ResponseEntity.ok()
            .body(new ProductResponseDto().convertJsonToEntity(product)))
        .orElse(ResponseEntity.notFound().build());
  }
}
