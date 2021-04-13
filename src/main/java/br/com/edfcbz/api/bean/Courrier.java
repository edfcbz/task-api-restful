/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean;

/**
 *
 * @author Eduardo
 */
public class Courrier {

    private Integer id;
    private String name;
    private Integer addressId;

    public Courrier() {
    }

    public Courrier(Integer id, String name, Integer addressId) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

}
