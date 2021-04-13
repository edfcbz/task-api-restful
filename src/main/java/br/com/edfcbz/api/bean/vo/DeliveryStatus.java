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
public class DeliveryStatus {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private Integer statusId;
    private Integer deliveryId;
    private Timestamp updateTime;
    
    public DeliveryStatus() {
    }

    public DeliveryStatus(Integer statusId, Integer deliveryId, Timestamp updateTime) {
        this.statusId = statusId;
        this.deliveryId = deliveryId;
        this.updateTime = updateTime;
    }
    
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}
