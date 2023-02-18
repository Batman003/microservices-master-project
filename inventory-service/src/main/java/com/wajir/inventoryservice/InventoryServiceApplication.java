package com.wajir.inventoryservice;

import com.wajir.inventoryservice.model.Inventory;
import com.wajir.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadInventory(InventoryRepository invRepo){
		return args -> {
			Inventory inv = new Inventory();
			inv.setSkuCode("iphone_13_purple");
			inv.setQuantity(100);

			Inventory inv2 = new Inventory();
			inv2.setSkuCode("Realme_GT_10");
			inv2.setQuantity(101);

			invRepo.save(inv);
			invRepo.save(inv2);
		};
	}
}
