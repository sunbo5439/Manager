package cn.pku.meizi.controller;

import cn.pku.meizi.domain.Order;
import cn.pku.meizi.domain.OrderItem;
import cn.pku.meizi.domain.User;
import cn.pku.meizi.enumer.OrderStatus;
import cn.pku.meizi.enumer.PayType;
import cn.pku.meizi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by sunbo on 16/6/24.
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService myOrderService;
    @RequestMapping("searchOrder")
    public String searchOrder(Model model , @RequestParam("uuid")String uuid){
        Order order=myOrderService.getOrderbyUUID(uuid);
        List<OrderItem> orderItems=null;
        String errMessage="";
        if(order==null) {
            errMessage="订单不存在";
            model.addAttribute("errMessage",errMessage);
        }
        else {
             orderItems = myOrderService.getOrderItembyOrderID(order.getId());
        }
        model.addAttribute("order",order);
        model.addAttribute("orderItems",orderItems);
        return "orderSearch";
    }
    /*@RequestMapping("orderdelete/{id}")
    public String orderDelete(@PathVariable Integer id){
        myOrderService.deleteByID(id);
        return "orderSearch";
    }
    @RequestMapping("orderedit/{id}")
    public String orderEdit(Model model, @PathVariable Integer id){
        Order order=myOrderService.getOrderByID(id);
        model.addAttribute("paytype", PayType.values());
        model.addAttribute("status", OrderStatus.values());
        model.addAttribute("order",order);
        return "orderEdit";
    }
    @RequestMapping("/orderupdate")
    public String orderUpdate(Model model,@ModelAttribute Order order){
        order.setmDate(new Date());
        myOrderService.updateOrder(order);
        model.addAttribute("order",order);
        return "orderSearch";
    }*/
}
