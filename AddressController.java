package br.com.edfcbz.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edfcbz.api.bean.vo.AddressVO;
import br.com.edfcbz.api.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "AddressEndpoint")
@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@Cacheable("address")
	@ApiOperation(value = "Find all Address" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<AddressVO> findAll(){
		List<AddressVO> list = service.findAll();
		list.forEach( p -> p.add(linkTo(methodOn(AddressController.class).findById(p.getKey())).withSelfRel()));	
		list.forEach( p -> p.add(linkTo(methodOn(CityController.class).findById(p.getCity().getKey())).withRel("City")));	
		list.forEach( p -> p.add(linkTo(methodOn(ProvinceController.class).findById(p.getCity().getProvince().getKey())).withRel("Province")));	
		list.forEach( p -> p.add(linkTo(methodOn(CountryController.class).findById(p.getCity().getProvince().getCountry().getKey())).withRel("Country")));	
		System.out.println("CONSULTANDO LISTA DE ENDEREÇOS");
		return list;
	}	
	
	@ApiOperation(value = "Find a specific Address by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public AddressVO findById(@PathVariable("id") int id) {
		AddressVO addressVO = service.findById(id);
		addressVO.add(linkTo(methodOn(AddressController.class).findById(id)).withSelfRel());	
		addressVO.getCity().add(linkTo(methodOn(CityController.class).findById(addressVO.getCity().getKey())).withRel("City"));	
		addressVO.getCity().getProvince().add(linkTo(methodOn(ProvinceController.class).findById(addressVO.getCity().getProvince().getKey())).withRel("Province"));	
		addressVO.getCity().getProvince().getCountry().add(linkTo(methodOn(CountryController.class).findById(addressVO.getCity().getProvince().getCountry().getKey())).withRel("Country"));	
		return addressVO;
				
	}	
	
	@ApiOperation(value = "Find a Address by name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<AddressVO> findByName(@PathVariable("name") String name) { 
		List<AddressVO> list = service.findByName(name);
		list.forEach( p -> p.add(linkTo(methodOn(AddressController.class).findById(p.getKey())).withSelfRel()));	
		list.forEach( p -> p.add(linkTo(methodOn(CityController.class).findById(p.getCity().getKey())).withRel("City")));	
		list.forEach( p -> p.add(linkTo(methodOn(ProvinceController.class).findById(p.getCity().getProvince().getKey())).withRel("Province")));	
		list.forEach( p -> p.add(linkTo(methodOn(CountryController.class).findById(p.getCity().getProvince().getCountry().getKey())).withRel("Country")));		
		return list;
				
	}	
	
	@ApiOperation(value = "Save a new City") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public AddressVO save(@RequestBody AddressVO addressVO){
		addressVO = service.save(addressVO);
		addressVO.add(linkTo(methodOn(AddressController.class).findById(addressVO.getKey())).withSelfRel());	
		addressVO.add(linkTo(methodOn(CityController.class).findById(addressVO.getCity().getKey())).withRel("City"));	
		addressVO.add(linkTo(methodOn(ProvinceController.class).findById(addressVO.getCity().getProvince().getKey())).withRel("Province"));	
		addressVO.add(linkTo(methodOn(CountryController.class).findById(addressVO.getCity().getProvince().getCountry().getKey())).withRel("Country"));		
		return addressVO;
	}
	
	@ApiOperation(value = "Update a specific City")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public AddressVO update(@RequestBody AddressVO addressVO){
		addressVO = service.update(addressVO);
		addressVO.add(linkTo(methodOn(AddressController.class).findById(addressVO.getKey())).withSelfRel());	
		addressVO.add(linkTo(methodOn(CityController.class).findById(addressVO.getCity().getKey())).withRel("City"));	
		addressVO.add(linkTo(methodOn(ProvinceController.class).findById(addressVO.getCity().getProvince().getKey())).withRel("Province"));	
		addressVO.add(linkTo(methodOn(CountryController.class).findById(addressVO.getCity().getProvince().getCountry().getKey())).withRel("Country"));	
		return addressVO;
	}	
	
	@ApiOperation(value = "Delete a specific Address by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
	@GetMapping(value = "/cleanning")
	@CacheEvict("address")
	public String cleanningCache(){
		return "Limpando cache";
	}		
	
	
}