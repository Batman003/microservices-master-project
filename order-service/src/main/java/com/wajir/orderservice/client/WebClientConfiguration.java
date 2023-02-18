package com.wajir.orderservice.client;

import com.wajir.orderservice.dto.InventoryResponse;
import com.wajir.orderservice.util.BaseURL;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import static com.wajir.orderservice.util.BaseURL.INVENTORY_BASE_URL;

@Component
@AllArgsConstructor
public class WebClientConfiguration {

    private final WebClient.Builder webClientBuilder;
    private static final String ENDPOINT = "/api/inventory";

    public InventoryResponse[] getInventory(List<String> skuCodes){
       InventoryResponse[] response = webClientBuilder.build().get()
               .uri(INVENTORY_BASE_URL+ENDPOINT,
                       uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
               .retrieve()
               .bodyToMono(InventoryResponse[].class)
               .block();
       return response;
    }
}
