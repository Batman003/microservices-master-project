package com.wajir.orderservice.service;

import com.wajir.orderservice.client.WebClientConfiguration;
import com.wajir.orderservice.dto.InventoryResponse;
import com.wajir.orderservice.dto.OrderLinesItemDTO;
import com.wajir.orderservice.dto.OrderRequest;
import com.wajir.orderservice.model.Order;
import com.wajir.orderservice.model.OrderLineItems;
import com.wajir.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {


    private final OrderRepository orderRepository;
    private final WebClientConfiguration webClient;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

     List<OrderLineItems> orderLineItemList =   orderRequest.getOrderLinesItemDTOList()
                .stream()
                .map(this::mapToDTO)
                .toList();
        order.setOrderLineItemsList(orderLineItemList);

       List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();
        //Called inventory service and place order if available
        InventoryResponse[] results = webClient.getInventory(skuCodes);
        System.out.println(Arrays.deepToString(results));
        boolean allProductInStock = Arrays.stream(results).allMatch(InventoryResponse::isInStock) && results.length==skuCodes.size();
        if(allProductInStock){
            orderRepository.save(order);
        }else{
            throw new IllegalArgumentException("Product is not in stock please try again later.");
        }

    }

    private OrderLineItems mapToDTO(OrderLinesItemDTO orderLinesItemDTO) {

        OrderLineItems orderLinesItem = new OrderLineItems();
        orderLinesItem.setPrice(orderLinesItemDTO.getPrice());
        orderLinesItem.setQuantity(orderLinesItemDTO.getQuantity());
        orderLinesItem.setSkuCode(orderLinesItemDTO.getSkuCode());
        return  orderLinesItem;
    }
}
