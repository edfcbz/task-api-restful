/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean.vo;
import java.sql.Timestamp;

/**
 *
 * @author Eduardo
 */
public class OrderStatus {

    private Integer orderId;
    private Integer statusId;
    private Timestamp lastUpdate;

    public OrderStatus() {
    }

    public OrderStatus(Integer orderId, Integer statusId, Timestamp lastUpdate) {
        this.orderId = orderId;
        this.statusId = statusId;
        this.lastUpdate = lastUpdate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
