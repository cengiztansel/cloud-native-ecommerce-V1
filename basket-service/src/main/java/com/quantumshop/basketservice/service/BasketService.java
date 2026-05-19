package com.quantumshop.basketservice.service;

import com.quantumshop.basketservice.model.BasketItem;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final RabbitTemplate rabbitTemplate;

    public BasketService(
            RedisTemplate<String, Object> redisTemplate,
            RabbitTemplate rabbitTemplate) {

        this.redisTemplate = redisTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    public BasketItem addItem(BasketItem item) {

        redisTemplate.opsForValue()
                .set(item.getProductName(), item);

        rabbitTemplate.convertAndSend(
                "basket.exchange",
                "basket.created",
                item.getProductName()
        );

        return item;
    }
}
