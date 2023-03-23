package com.example.virtualshop.service;

import com.example.virtualshop.Product;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

import static com.example.virtualshop.enums.Markup.*;
import static com.example.virtualshop.enums.Markup.PRODUCT_D_MARKUP;
import static com.example.virtualshop.enums.ProductPromotion.*;
import static com.example.virtualshop.enums.UnitCost.*;
import static com.example.virtualshop.enums.UnitCost.PRODUCT_D_UNIT_COST;
import static com.example.virtualshop.outputs.ExceptionMessages.UNKNOWN_PRODUCT;
import static com.example.virtualshop.outputs.SuccessMessages.*;

@Service
public class ProductService {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public double calculateTotalPriceAfterBasicDiscount(int quantity, double promotionalUnitPrice, double basicClientDiscount) {
        double discount;
        double totalPrice = promotionalUnitPrice * quantity;
        if (basicClientDiscount == 1) {
            discount = 0;
        } else {
            discount = totalPrice * basicClientDiscount;
        }
        return totalPrice - discount;
    }

    public double calculateTotalPriceBeforeBasicClientDiscount(int quantity, double promotionalUnitPrice) {
        return promotionalUnitPrice * quantity;
    }

    public double calculateBaseUnitPrice(Product product) {
        if (product.getType().equals("A") || product.getType().equals("B")) {
            return (product.getUnitCost() * product.getMarkup()) + product.getUnitCost();
        } else {
            return product.getUnitCost() + product.getMarkup();
        }
    }

    public double calculatePromotionalUnitPrice(double baseUnitPrice, double productPromotion) {
        if (productPromotion == 1) {
            return baseUnitPrice * productPromotion;
        } else {
            double discount = baseUnitPrice * productPromotion;
            return baseUnitPrice - discount;
        }
    }

    public double calculateOrderTotalAmount(double firstProductTotalAfterBasicDiscount, double secondProductTotalAfterBasicDiscount, double additionalDiscount) {
        return (firstProductTotalAfterBasicDiscount + secondProductTotalAfterBasicDiscount) - additionalDiscount;
    }

    public Product createProduct(int productQuantity, String productType) {
        Product product = new Product();
        product.setType(productType);
        product.setQuantity(productQuantity);
        return product;
    }

    public void fillProduct(Product product) {
        switch (product.getType()) {
            case "A":
                product.setUnitCost(PRODUCT_A_UNIT_COST)
                .setMarkup(PRODUCT_A_MARKUP)
                .setBaseUnitPrice(calculateBaseUnitPrice(product))
                .setPromotionalUnitPrice(calculatePromotionalUnitPrice(product.getBaseUnitPrice(), PRODUCT_A_PROMOTION));
                break;
//
            case "B":
                product.setUnitCost(PRODUCT_B_UNIT_COST)
                .setMarkup(PRODUCT_B_MARKUP)
                .setBaseUnitPrice(calculateBaseUnitPrice(product))
                .setPromotionalUnitPrice(calculatePromotionalUnitPrice(product.getBaseUnitPrice(), PRODUCT_B_PROMOTION));
                break;

            case "C":
                product.setUnitCost(PRODUCT_C_UNIT_COST)
                .setMarkup(PRODUCT_C_MARKUP)
                .setBaseUnitPrice(calculateBaseUnitPrice(product))
                .setPromotionalUnitPrice(calculatePromotionalUnitPrice(product.getBaseUnitPrice(), PRODUCT_C_PROMOTION));
                break;

            case "D":
                product.setUnitCost(PRODUCT_D_UNIT_COST)
                .setMarkup(PRODUCT_D_MARKUP)
                .setBaseUnitPrice(calculateBaseUnitPrice(product))
                .setPromotionalUnitPrice(calculateAveragePromUnitPrice(product));
                break;

            default:
                throw new IllegalArgumentException(UNKNOWN_PRODUCT);
        }
    }

    public  double calculateAveragePromUnitPrice(Product product) {
        return (2 * (product.getBaseUnitPrice())) / 3;
    }

    public void printProductInfo(Product product, double productTotalAmount) {
        System.out.printf(PRODUCT_INFO,
                product.getType(),
                product.getQuantity(),
                decimalFormat.format(product.getBaseUnitPrice()),
                product.getPromotionalUnitPrice() == product.getBaseUnitPrice() ? "none" : decimalFormat.format(product.getPromotionalUnitPrice()),
                decimalFormat.format(productTotalAmount));
    }

    public void printOrderInfo(double totalAmountBeforeClientDiscount, double additionalDiscount, double orderTotalAmount) {
        System.out.printf(TOTAL_AMOUNT_NO_CLIENT_DISCOUNT, decimalFormat.format(totalAmountBeforeClientDiscount));
        System.out.printf(ADDITIONAL_DISCOUNT_APPLIED, decimalFormat.format(additionalDiscount));
        System.out.printf(ORDER_FINAL_AMOUNT, decimalFormat.format(orderTotalAmount));
    }

}
