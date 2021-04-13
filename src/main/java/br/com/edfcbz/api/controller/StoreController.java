package br.com.edfcbz.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.edfcbz.api.bean.vo.StoreVO;
import br.com.edfcbz.api.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "StoreEndpoint")
@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@ApiOperation(value = "Find all Store" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<StoreVO> findAll(){
		List<StoreVO> list = service.findAll();
			list.forEach( p -> p.add(linkTo(methodOn(StoreController.class).findById(p.getKey())).withSelfRel()));	
			list.forEach( p -> p.getAddress().add(linkTo(methodOn(AddressController.class).findById(p.getAddress().getKey())).withRel("Address")));	
			list.forEach( p -> p.getAddress().getCity().add(linkTo(methodOn(CityController.class).findById(p.getAddress().getCity().getKey())).withRel("City")));	
			list.forEach( p -> p.getAddress().getCity().getProvince().add(linkTo(methodOn(ProvinceController.class).findById(p.getAddress().getCity().getProvince().getKey())).withRel("Province")));	
			list.forEach( p -> p.getAddress().getCity().getProvince().getCountry().add(linkTo(methodOn(CountryController.class).findById(p.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country")));	
		return list;
	}	
	
	@ApiOperation(value = "Find a specific Address by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public StoreVO findById(@PathVariable("id") int id) {
		StoreVO storeVO = service.findById(id);
		storeVO.add(linkTo(methodOn(StoreController.class).findById(storeVO.getKey())).withSelfRel());	
		storeVO.getAddress().add(linkTo(methodOn(AddressController.class).findById(storeVO.getAddress().getKey())).withRel("Address"));	
		storeVO.getAddress().getCity().add(linkTo(methodOn(CityController.class).findById(storeVO.getAddress().getCity().getKey())).withRel("City"));	
		storeVO.getAddress().getCity().getProvince().add(linkTo(methodOn(ProvinceController.class).findById(storeVO.getAddress().getCity().getProvince().getKey())).withRel("Province"));	
		storeVO.getAddress().getCity().getProvince().getCountry().add(linkTo(methodOn(CountryController.class).findById(storeVO.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country"));	
		return storeVO;
				
	}	
	
	@ApiOperation(value = "Find a Store by name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<StoreVO> findByName(@PathVariable("name") String name) { 
		List<StoreVO> list = service.findByName(name);
		list.forEach( p -> p.add(linkTo(methodOn(StoreController.class).findById(p.getKey())).withSelfRel()));	
		list.forEach( p -> p.getAddress().add(linkTo(methodOn(AddressController.class).findById(p.getAddress().getKey())).withRel("Address")));	
		list.forEach( p -> p.getAddress().getCity().add(linkTo(methodOn(CityController.class).findById(p.getAddress().getCity().getKey())).withRel("City")));	
		list.forEach( p -> p.getAddress().getCity().getProvince().add(linkTo(methodOn(ProvinceController.class).findById(p.getAddress().getCity().getProvince().getKey())).withRel("Province")));	
		list.forEach( p -> p.getAddress().getCity().getProvince().getCountry().add(linkTo(methodOn(CountryController.class).findById(p.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country")));
		return list;
				
	}	
	
	@ApiOperation(value = "Save a new City") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public StoreVO save(@RequestBody StoreVO storeVO){
		storeVO = service.save(storeVO);
		storeVO.add(linkTo(methodOn(StoreController.class).findById(storeVO.getKey())).withSelfRel());	
		storeVO.getAddress().add(linkTo(methodOn(AddressController.class).findById(storeVO.getAddress().getKey())).withRel("Address"));	
		storeVO.getAddress().getCity().add(linkTo(methodOn(CityController.class).findById(storeVO.getAddress().getCity().getKey())).withRel("City"));	
		storeVO.getAddress().getCity().getProvince().add(linkTo(methodOn(ProvinceController.class).findById(storeVO.getAddress().getCity().getProvince().getKey())).withRel("Province"));	
		storeVO.getAddress().getCity().getProvince().getCountry().add(linkTo(methodOn(CountryController.class).findById(storeVO.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country"));
		return storeVO;
	}
	
	@ApiOperation(value = "Update a specific Store")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public StoreVO update(@RequestBody StoreVO storeVO){
		storeVO = service.update(storeVO);
		storeVO.getAddress().add(linkTo(methodOn(AddressController.class).findById(storeVO.getAddress().getKey())).withRel("Address"));	
		storeVO.getAddress().getCity().add(linkTo(methodOn(CityController.class).findById(storeVO.getAddress().getCity().getKey())).withRel("City"));	
		storeVO.getAddress().getCity().getProvince().add(linkTo(methodOn(ProvinceController.class).findById(storeVO.getAddress().getCity().getProvince().getKey())).withRel("Province"));	
		storeVO.getAddress().getCity().getProvince().getCountry().add(linkTo(methodOn(CountryController.class).findById(storeVO.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country"));
		return storeVO;
	}	
	
	@ApiOperation(value = "Delete a specific Address by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}