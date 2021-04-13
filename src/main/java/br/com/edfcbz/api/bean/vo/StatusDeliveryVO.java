/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean.vo;

import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class StatusDeliveryVO {

    private Integer statusId;
    private Integer deliveryId;
    private Date updateTime;

    public StatusDeliveryVO() {
    }

    public StatusDeliveryVO(Integer statusId, Integer deliveryId, Date updateTime) {
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
