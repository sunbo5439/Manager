package cn.pku.meizi.service;

import cn.pku.meizi.domain.Order;
import cn.pku.meizi.domain.OrderItem;

import java.util.List;

/**
 * Created by sunbo on 16/6/24.
 */
public interface OrderService {
    List<Order> listAllOrders();
    Order getOrderByID(Integer id);
    Order getOrderbyUUID(String uuid);
    void deleteByUUID(String uuid);
    void deleteByID(Integer id);
    boolean updateOrder(Order user);
    List<OrderItem> getOrderItembyOrderID(Integer id);
}
