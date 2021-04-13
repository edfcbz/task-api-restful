/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean.vo;

/**
 *
 * @author Eduardo
 */
public class DeliveryVO {

    private Integer id;
    private Integer courrierId;
    private Integer orderId;
    private Integer storeId;

    public DeliveryVO() {
    }

    public DeliveryVO(Integer id, Integer courrierId, Integer orderId, Integer storeId) {
        this.id = id;
        this.courrierId = courrierId;
        this.orderId = orderId;
        this.storeId = storeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourrierId() {
        return courrierId;
    }

    public void setCourrierId(Integer courrierId) {
        this.courrierId = courrierId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

}
