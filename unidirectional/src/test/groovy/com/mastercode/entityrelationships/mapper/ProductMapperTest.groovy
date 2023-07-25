package com.mastercode.entityrelationships.mapper

import com.mastercode.entityrelationships.entity.Product
import com.mastercode.entityrelationships.model.request.ProductRequest
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class ProductMapperTest extends Specification {
    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    private ProductMapper productMapper

    def setup() {
        productMapper = ProductMapper.INSTANCE
    }

    def "MapToProduct"() {
        given:
        def request = random.nextObject(ProductRequest)

        when:
        def actual = productMapper.mapToProduct(request)

        then:
        request.sku == actual.sku
        request.name == actual.name
        request.description == actual.description
        request.price == actual.price
        request.active == actual.active
        request.imageUrl == actual.imageUrl
    }

    def "MapToProductResponse"() {
        given:
        def entity = random.nextObject(Product)

        when:
        def actual = productMapper.mapToProductResponse(entity)

        then:
        entity.id == actual.id
        entity.sku == actual.sku
        entity.name == actual.name
        entity.description == actual.description
        entity.price == actual.price
        entity.active == actual.active
        entity.createdDate == actual.createdDate
        entity.lastModifiedDate == actual.lastModifiedDate
        entity.createdBy == actual.createdBy
        entity.lastModifiedBy == actual.lastModifiedBy
    }


    def "MapToProductResponseList"() {
        given:
        def entity = List.of(
                random.nextObject(Product),
                random.nextObject(Product),
                random.nextObject(Product)
        )

        when:
        def actual = productMapper.mapToProductResponseList(entity )

        then:
        entity.id == actual.id
        entity.sku == actual.sku
        entity.name == actual.name
        entity.description == actual.description
        entity.price == actual.price
        entity.active == actual.active
        entity.createdDate == actual.createdDate
        entity.lastModifiedDate == actual.lastModifiedDate
        entity.createdBy == actual.createdBy
        entity.lastModifiedBy == actual.lastModifiedBy
    }
}
