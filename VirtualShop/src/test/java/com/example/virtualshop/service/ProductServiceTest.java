package com.example.virtualshop.service;

import com.example.virtualshop.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    @Test
    void basicClientDiscountValue1() {
        ProductService productService = new ProductService();
        double basicClientDiscount = 1;
        double promotionalUnitPrice = 0.55;
        int quantity = 1000;
        double sum = productService.calculateTotalPriceAfterBasicDiscount(quantity,promotionalUnitPrice,basicClientDiscount);
           assertEquals(550,sum);
    }

    @Test
    void basicClientDiscountValueDifferentThan1() {
        ProductService productService = new ProductService();
        double basicClientDiscount = 0.03;
        double promotionalUnitPrice = 0.55;
        int quantity = 1000;
        double sum = productService.calculateTotalPriceAfterBasicDiscount(quantity,promotionalUnitPrice,basicClientDiscount);
        assertEquals(533.5,sum);
    }


    @Test
    void calculateTotalPriceBeforeBasicClientDiscount() {
        ProductService productService = new ProductService();
        double sum = productService.calculateTotalPriceBeforeBasicClientDiscount(3, 4);
        assertEquals(12,sum);
    }

    @Test
    void getBaseUnitPriceSuccessByMultiply(){
        ProductService productService = new ProductService();
        Product product = new Product()
                .setType("A")
                .setUnitCost(0.9)
                .setMarkup(0.8);

        assertEquals(1.62,productService.calculateBaseUnitPrice(product));
    }

    @Test
    void getBaseUnitPriceSuccessByAdd(){
        ProductService productService = new ProductService();
        Product product = new Product()
                .setType("C")
                .setUnitCost(0.5)
                .setMarkup(1.2);

        assertEquals(1.7,productService.calculateBaseUnitPrice(product));
    }

    @Test
    void PromotionalUnitPriceWithoutPromotion(){
        ProductService productService = new ProductService();
        double basicUnitPrice = 0.5;
        double productPromotion = 1;
        double sum = productService.calculatePromotionalUnitPrice(basicUnitPrice,productPromotion);
        assertEquals(0.5,sum);
    }

    @Test
    void PromotionalUnitPriceWithPromotion(){
        ProductService productService = new ProductService();
        double basicUnitPrice = 0.5;
        double productPromotion = 0.3;
        double sum = productService.calculatePromotionalUnitPrice(basicUnitPrice,productPromotion);
        assertEquals(0.35,sum);
    }

    @Test
    void  calculateOrderTotalAmount(){
        ProductService productService = new ProductService();

        double firstProductTotalAfterBasicDiscount = 5250.43;
        double secondProductTotalAfterBasicDiscount = 4850.57;
        double additionalDiscount = 101;

        double sum = productService.calculateOrderTotalAmount(
                firstProductTotalAfterBasicDiscount,
                secondProductTotalAfterBasicDiscount,
                additionalDiscount);

        assertEquals(10000,sum);
    }

    @Test
      void calculateAveragePromUnitPrice( ) {
        Product product = new Product().setBaseUnitPrice(1.50);
        ProductService productService = new ProductService();

       assertEquals(1,productService.calculateAveragePromUnitPrice(product));
    }

}