package com.example.virtualshop;

import com.example.virtualshop.service.ClientService;
import com.example.virtualshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Scanner;

import static com.example.virtualshop.enums.discount.BasicClientDiscount.*;
import static com.example.virtualshop.enums.discount.additionalVolumeDiscount.Above10000.*;
import static com.example.virtualshop.enums.discount.additionalVolumeDiscount.Above30000.*;
import static com.example.virtualshop.outputs.ExceptionMessages.WRONG_CLIENT_ID;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final Scanner scanner = new Scanner(System.in);
    private static final int TARGET_FOR_SMALL_DISCOUNT = 10000;
    private static final int TARGET_FOR_BIG_DISCOUNT = 30000;
    private final ProductService productService;
    private final ClientService clientService;

    @Autowired
    public CommandLineRunnerImpl(ProductService productService, ClientService clientService) {
        this.productService = productService;
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {

        String[] line = scanner.nextLine().split("\\s+");
        int clientId = Integer.parseInt(line[0]);
        int firstProductQuantity = Integer.parseInt(line[1]);
        String firstProductType = line[2];
        int secondProductQuantity = Integer.parseInt(line[3]);
        String secondProductType = line[4];

        Product firstProduct = this.productService.createProduct(firstProductQuantity, firstProductType);
        Product secondProduct = this.productService.createProduct(secondProductQuantity, secondProductType);

        this.productService.fillProduct(firstProduct);
        this.productService.fillProduct(secondProduct);

        Client client = new Client();
        client.setId(clientId);

        if (clientId == 1) {
            this.clientService.setClientDiscounts(client, BASIC_DISCOUNT_ID1, ADDITIONAL_VOLUME_DISCOUNT_1, ADDITIONAL_VOLUME_DISCOUNT_ID_1);
        } else if (clientId == 2) {
            this.clientService.setClientDiscounts(client, BASIC_DISCOUNT_ID2, ADDITIONAL_VOLUME_DISCOUNT_2, ADDITIONAL_VOLUME_DISCOUNT_ID_2);
        } else if (clientId == 3) {
            this.clientService.setClientDiscounts(client, BASIC_DISCOUNT_ID3, ADDITIONAL_VOLUME_DISCOUNT_3, ADDITIONAL_VOLUME_DISCOUNT_ID_3);
        } else if (clientId == 4) {
            this.clientService.setClientDiscounts(client, BASIC_DISCOUNT_ID4, ADDITIONAL_VOLUME_DISCOUNT_4, ADDITIONAL_VOLUME_DISCOUNT_ID_4);
        } else if (clientId == 5) {
            this.clientService.setClientDiscounts(client, BASIC_DISCOUNT_ID5, ADDITIONAL_VOLUME_DISCOUNT_5, ADDITIONAL_VOLUME_DISCOUNT_ID_5);
        }else{
            throw new IllegalArgumentException(WRONG_CLIENT_ID);
        }

        double firstProductTotalAfterBasicDiscount = this.productService.calculateTotalPriceAfterBasicDiscount(
                firstProductQuantity,
                firstProduct.getPromotionalUnitPrice(),
                client.getBasicDiscount());

        double secondProductTotalAfterBasicDiscount = this.productService.calculateTotalPriceAfterBasicDiscount(
                secondProductQuantity,
                secondProduct.getPromotionalUnitPrice(),
                client.getBasicDiscount());


        double firstProductBeforeBasicDiscount = this.productService.calculateTotalPriceBeforeBasicClientDiscount(
                firstProductQuantity,
                firstProduct.getPromotionalUnitPrice());

        double secondProductBeforeBasicDiscount = this.productService.calculateTotalPriceBeforeBasicClientDiscount(
                secondProductQuantity,
                secondProduct.getPromotionalUnitPrice());

        double totalAmountWithBasicDiscount = firstProductTotalAfterBasicDiscount + secondProductTotalAfterBasicDiscount;
        double totalAmountBeforeClientDiscount = firstProductBeforeBasicDiscount + secondProductBeforeBasicDiscount;

        double additionalDiscount = 0;
        if (totalAmountBeforeClientDiscount > TARGET_FOR_SMALL_DISCOUNT && totalAmountBeforeClientDiscount < TARGET_FOR_BIG_DISCOUNT) {
            additionalDiscount = totalAmountWithBasicDiscount * client.getAdditionalVolumeDiscountAbove10000();
        } else if (totalAmountBeforeClientDiscount > TARGET_FOR_BIG_DISCOUNT) {
            additionalDiscount = totalAmountWithBasicDiscount * client.getAdditionalVolumeDiscountAbove30000();
        }

        double orderTotalAmount = this.productService.calculateOrderTotalAmount(firstProductTotalAfterBasicDiscount, secondProductTotalAfterBasicDiscount, additionalDiscount);

        this.productService.printProductInfo(firstProduct,firstProductTotalAfterBasicDiscount);
        this.productService.printProductInfo(secondProduct, secondProductTotalAfterBasicDiscount);

        this.productService.printOrderInfo(totalAmountBeforeClientDiscount, additionalDiscount, orderTotalAmount);
    }

}
