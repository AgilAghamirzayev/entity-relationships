package com.mastercode.entityrelationships.service

import com.mastercode.entityrelationships.entity.Product
import com.mastercode.entityrelationships.model.request.ProductRequest
import com.mastercode.entityrelationships.model.request.UpdateProductRequest
import com.mastercode.entityrelationships.repository.ProductRepository
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class ProductServiceTest extends Specification {

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()
    private ProductRepository productRepository
    private ProductService productService

    def setup() {
        productRepository = Mock()
        productService = new ProductService(productRepository)
    }

    def "GetProductById success case"() {
        given:
        def id = random.nextObject(Long)
        def expected = random.nextObject(Product)

        when:
        def actual = productService.getProductById(id)

        then:
        1 * productRepository.findById(id) >> Optional.of(expected)
        actual.id == expected.id
        actual.sku == expected.sku
        actual.name == expected.name
        actual.description == expected.description
        actual.price == expected.price
        actual.active == expected.active
        actual.imageUrl == expected.imageUrl
        actual.createdDate == expected.createdDate
        actual.lastModifiedDate == expected.lastModifiedDate
        actual.createdBy == expected.createdBy
        actual.lastModifiedBy == expected.lastModifiedBy
    }


    def "GetProductById not found case"() {
        given:
        def id = random.nextObject(Long)

        when:
        productService.getProductById(id)

        then:
        1 * productRepository.findById(id) >> Optional.empty()
        RuntimeException ex = thrown()
        ex.message == "Could not find product"
    }

    // TODO: Ask from teacher
    def "SearchProducts success full list"() {
        given:
        def query = random.nextObject(String)
        def expected = List.of(
                random.nextObject(Product),
                random.nextObject(Product),
                random.nextObject(Product)
        )

        when:
        def actual = productService.searchProducts(query)

        then:
        1 * productRepository.searchProducts(query) >> expected
        actual.size() == expected.size()
        actual.id == expected.id
        actual.sku == expected.sku
        actual.name == expected.name
        actual.description == expected.description
        actual.price == expected.price
        actual.active == expected.active
        actual.imageUrl == expected.imageUrl
        actual.createdDate == expected.createdDate
        actual.lastModifiedDate == expected.lastModifiedDate
        actual.createdBy == expected.createdBy
        actual.lastModifiedBy == expected.lastModifiedBy
    }

    def "SearchProducts success empty list"() {
        given:
        def query = random.nextObject(String)
        def expected = List.of()

        when:
        def actual = productService.searchProducts(query)

        then:
        1 * productRepository.searchProducts(query) >> expected
        actual.size() == expected.size()
    }

    def "CreateProduct with valid request"() {
        given:
        def request = random.nextObject(ProductRequest)
        def entity = Product.builder()
                .name(request.name)
                .sku(request.sku)
                .description(request.description)
                .price(request.price)
                .active(request.active)
                .imageUrl(request.imageUrl)
                .build()

        when:
        productService.createProduct(request)


        then:
        1 * productRepository.save(entity)
    }

    def "CreateProduct with null request"() {
        given:
        def request = null
        def entity = null

        when:
        productService.createProduct(request)

        then:
        0 * productRepository.save(entity)
    }

    def "UpdateProduct with valid request"() {
        given:
        def id = random.nextObject(Long)
        def request = random.nextObject(UpdateProductRequest)
        def expected = random.nextObject(Product)

        when:
        productService.updateProduct(id, request)

        then:
        1 * productRepository.findById(id) >> Optional.of(expected)
        1 * productRepository.save(expected)

        request.name == expected.name
        request.active == expected.active
        request.price == expected.price
    }

    def "UpdateProduct with request fields null"() {
        given:
        def id = random.nextObject(Long)
        def request = UpdateProductRequest.builder().build()
        def expected = random.nextObject(Product)

        when:
        productService.updateProduct(id, request)

        then:
        1 * productRepository.findById(id) >> Optional.of(expected)
        1 * productRepository.save(expected)

        request.name != expected.name
        request.active != expected.active
        request.price != expected.price
    }


    def "UpdateProduct with request null"() {
        given:
        def id = random.nextObject(Long)
        def request = null

        when:
        productService.updateProduct(id, request)

        then:
        1 * productRepository.findById(id) >> Optional.empty()
        0 * productRepository.save()

        RuntimeException ex = thrown()
        ex.message == "Could not find product"
    }

    def "DeleteProduct success"() {
        given:
        def id = random.nextObject(Long)
        def entity = random.nextObject(Product)
        entity.setIsDeleted(Boolean.FALSE)

        when:
        productService.deleteProduct(id)

        then:
        1 * productRepository.findById(id) >> Optional.of(entity)
        1 * productRepository.save(entity)

        entity.isDeleted == Boolean.TRUE
    }

    def "DeleteProduct error"() {
        given:
        def id = random.nextObject(Long)
        def entity = random.nextObject(Product)
        entity.setIsDeleted(Boolean.FALSE)

        when:
        productService.deleteProduct(id)

        then:
        1 * productRepository.findById(id) >> Optional.empty()
        0 * productRepository.save()

        RuntimeException ex = thrown()
        ex.message == "Could not find product"
        entity.isDeleted == Boolean.FALSE
    }

}
