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
public class StoreAvailability {

    private Integer storeId;
    private Integer availabilityId;

    public StoreAvailability() {
    }

    public StoreAvailability(Integer storeId, Integer availabilityId) {
        this.storeId = storeId;
        this.availabilityId = availabilityId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Integer availabilityId) {
        this.availabilityId = availabilityId;
    }

}
