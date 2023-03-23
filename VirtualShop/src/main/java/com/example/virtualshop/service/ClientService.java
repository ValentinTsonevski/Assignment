package com.example.virtualshop.service;

import com.example.virtualshop.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    public   void setClientDiscounts(Client client, double basicDiscount, double additionalVolumeDiscount10k, double additionalVolumeDiscount30k) {
        client.setBasicDiscount(basicDiscount)
        .setAdditionalVolumeDiscountAbove10000(additionalVolumeDiscount10k)
        .setAdditionalVolumeDiscountAbove30000(additionalVolumeDiscount30k);
    }
}
