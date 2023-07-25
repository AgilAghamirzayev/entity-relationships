package com.mastercode.entityrelationships.controller

import com.mastercode.entityrelationships.model.response.ProductResponse
import com.mastercode.entityrelationships.service.ProductService
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import java.time.LocalDateTime
import java.time.ZoneId

class ProductControllerTest extends Specification {
    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()
    private ProductService productService
    private MockMvc mockMvc

    def setup() {
        productService = Mock()
        def productController = new ProductController(productService)
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
//        .setControllerAdvice(new ErrorHandler())
                .build()
    }

    def "GetProductById"() {
        given:
        def id = random.nextObject(Long)
        def url = "/v1/products/$id"

        def productResponse = ProductResponse.builder()
                .id(1)
                .sku("2")
                .name("3")
                .description("4")
                .price(BigDecimal.TEN)
                .active(Boolean.TRUE)
                .imageUrl("5")
                .createdDate(LocalDateTime.of(2023, 10, 10, 12, 12).atZone(ZoneId.systemDefault()).toInstant())
                .lastModifiedDate(LocalDateTime.of(2023, 10, 10, 12, 12).atZone(ZoneId.systemDefault()).toInstant())
                .createdBy("6")
                .lastModifiedBy("7")
                .build();

        when:

        then:

    }


}
