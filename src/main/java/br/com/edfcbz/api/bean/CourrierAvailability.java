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
public class CourrierAvailability {

    private Integer courrierId;
    private Integer availabilityId;
    private Boolean status;

    public CourrierAvailability() {
    }

    public CourrierAvailability(Integer courrierId, Integer availabilityId, Boolean status) {
        this.courrierId = courrierId;
        this.availabilityId = availabilityId;
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCourrierId() {
        return courrierId;
    }

    public void setCourrierId(Integer courrierId) {
        this.courrierId = courrierId;
    }

    public Integer getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Integer availabilityId) {
        this.availabilityId = availabilityId;
    }
}
