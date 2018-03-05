package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private OrderService orderService;
    private InformationService informationService;
    private OrderRepository orderRepository;

    OrderProcessor(final OrderService orderService,
                   final InformationService informationService,
                   final OrderRepository orderRepository) {

        this.orderService = orderService;
        this.informationService = informationService;
        this.orderRepository = orderRepository;
    }

    public boolean process(OrderRequest orderRequest) {

        boolean isOrdered = orderService.order(orderRequest.getUser(),
                    orderRequest.getProduct(), orderRequest.getQuantity());

        if (isOrdered) {
            orderRepository.createOrder(orderRequest);
            informationService.inform(orderRequest.getUser());
            return true;
        } else {
            return false;
        }
    }
}
