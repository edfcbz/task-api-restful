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
public class StoreCousine {

    private Integer storeId;
    private Integer cousineId;

    public StoreCousine() {
    }

    public StoreCousine(Integer storeId, Integer cousineId) {
        this.storeId = storeId;
        this.cousineId = cousineId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCousineId() {
        return cousineId;
    }

    public void setCousineId(Integer cousineId) {
        this.cousineId = cousineId;
    }

   

}
