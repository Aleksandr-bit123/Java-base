package com.aston.javabase.serialisation.serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter
@ToString
public class Order implements Serializable {

//    private static final long serialVersionUID = 1L;

    private int orderId;
    private Customer customer;
}

//public int getOrderId() {
//    return orderId;
//}
//
//public void setOrderId(int orderId) {
//    this.orderId = orderId;
//}
//
//public Customer getCustomer() {
//    return customer;
//}
//
//public void setCustomer(Customer customer) {
//    this.customer = customer;
//}
//
//@Override
//public String toString() {
//    return "Order{" +
//            "orderId=" + orderId +
//            ", customer=" + customer +
//            '}';
//}