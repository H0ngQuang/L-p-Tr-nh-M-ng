/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 20241132L;
    public String id,customerCode,  orderDate, shippingType,orderCode;

    public Order(String id, String customerCode, String orderDate, String shippingType) {
        this.id = id;
        this.customerCode = customerCode;
        this.orderDate = orderDate;
        this.shippingType = shippingType;
//        this.orderCode = orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getId() {
        return id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }
    
}
