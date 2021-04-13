/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edfcbz.api.bean.to;

import org.springframework.stereotype.Service;

import br.com.edfcbz.api.bean.Country;

/**
 *
 * @author Eduardo
 */
@Service
public class ProvinceTO {
    
    private Integer id;
    private String name;
    private String sigle;
    private CountryTO country;
    //private Country country;
    
    public ProvinceTO() {
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

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public CountryTO getCountry() {
		return country;
	}

	public void setCountry(CountryTO countryTO) {
		this.country = countryTO;
	}



    
    
}
