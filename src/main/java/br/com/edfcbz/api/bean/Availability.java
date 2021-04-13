/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean;

import java.sql.Timestamp;

/**
 *
 * @author Eduardo
 */
public class Availability {

    private Integer id;
//    private DateTime startAvailability;
//    private DateTime finishAvailability;

//    private LocalDateTime startAvailability;
//    private LocalDateTime finishAvailability;
    
    private Timestamp dateInitial;
    private Timestamp dateFinal;

    public Availability() {
    }

    public Availability(Integer id, Timestamp dateInitial, Timestamp dateFinal) {
        this.id = id;
        this.dateInitial = dateInitial;
        this.dateFinal = dateFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDateInitial() {
        return dateInitial;
    }

    public void setDateInitial(Timestamp dateInitial) {
        this.dateInitial = dateInitial;
    }

    public Timestamp getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Timestamp dateFinal) {
        this.dateFinal = dateFinal;
    }


   
}
