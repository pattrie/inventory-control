package br.com.mba.inventorycontrol.service;

import static br.com.mba.inventorycontrol.template.ProductRequestDtoTemplate.PRODUCT;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import br.com.mba.inventorycontrol.repository.AddressRepository;
import br.com.mba.inventorycontrol.repository.CategoryRepository;
import br.com.mba.inventorycontrol.repository.ProductInRepository;
import br.com.mba.inventorycontrol.repository.ProductRepository;
import br.com.mba.inventorycontrol.repository.StoragePlaceRepository;
import br.com.mba.inventorycontrol.repository.SupplierRepository;
import br.com.mba.inventorycontrol.template.CategoryTemplate;
import br.com.mba.inventorycontrol.template.ProductInTemplate;
import br.com.mba.inventorycontrol.template.ProductRequestDtoTemplate;
import br.com.mba.inventorycontrol.template.ProductTemplate;
import br.com.mba.inventorycontrol.template.SupplierTemplate;
import java.util.Optional;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @InjectMocks
  private ProductService productService;
  @Mock
  private ProductRepository productRepository;
  @Mock
  private CategoryRepository categoryRepository;
  @Mock
  private SupplierRepository supplierRepository;
  @Mock
  private StoragePlaceRepository storagePlaceRepository;
  @Mock
  private AddressRepository addressRepository;
  @Mock
  private ProductInRepository productInRepository;

  @Test
  void shouldCreateNewProductWithValidIds() {
    val category = CategoryTemplate.CATEGORY;
    val supplier = SupplierTemplate.SUPPLIER;
    val product = ProductTemplate.PRODUCT;
    val productIn = ProductInTemplate.PRODUCT_IN;

    when(categoryRepository.findById(anyInt())).thenReturn(Optional.of(category));
    when(supplierRepository.findById(anyInt())).thenReturn(Optional.of(supplier));
    when(productRepository.save(any())).thenReturn(product);
    when(productInRepository.save(any())).thenReturn(productIn);

    val savedProduct = productService.create(PRODUCT);

    assertNotNull(savedProduct);
  }

  @Test
  void shouldCreateNewProductWithNullIds() {
    val category = CategoryTemplate.CATEGORY;
    val supplier = SupplierTemplate.SUPPLIER;
    val product = ProductTemplate.PRODUCT;
    val productRequestDto = ProductRequestDtoTemplate.PRODUCT;
    productRequestDto.getCategory().setId(null);
    productRequestDto.getSupplier().setId(null);
    val productIn = ProductInTemplate.PRODUCT_IN;

    when(categoryRepository.save(any())).thenReturn(category);
    when(supplierRepository.save(any())).thenReturn(supplier);
    when(productRepository.save(any())).thenReturn(product);
    when(productInRepository.save(any())).thenReturn(productIn);

    val savedProduct = productService.create(productRequestDto);

    assertNotNull(savedProduct);
  }
}