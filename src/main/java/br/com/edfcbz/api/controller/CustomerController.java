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

import br.com.edfcbz.api.bean.vo.CustomerVO;
import br.com.edfcbz.api.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "CustomerEndpoint")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@ApiOperation(value = "Find all Customers" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CustomerVO> findAll(){
		List<CustomerVO> list = service.findAll();
		list.forEach( customer -> customer.add(linkTo(methodOn(CustomerController.class).findById(customer.getKey())).withSelfRel()));	
//		list.forEach( customer -> customer.add(linkTo(methodOn(AddressController.class).findById(customer.getAddress().getKey())).withRel("Address")));
//		list.forEach( customer -> customer.add(linkTo(methodOn(CityController.class).findById(customer.getAddress().getCity().getKey())).withRel("City")));
//		list.forEach( customer -> customer.add(linkTo(methodOn(ProvinceController.class).findById(customer.getAddress().getCity().getProvince().getKey())).withRel("Province")));
//		list.forEach( customer -> customer.add(linkTo(methodOn(CountryController.class).findById(customer.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country")));
		return list;
	}	
	
	@ApiOperation(value = "Find a specific Customer by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public CustomerVO findById(@PathVariable("id") int id) {
		CustomerVO vo = service.findById(id);
		vo.add(linkTo(methodOn(CustomerController.class).findById(vo.getKey())).withSelfRel());	
//		vo.add(linkTo(methodOn(AddressController.class).findById(vo.getAddress().getKey())).withRel("Address"));	
//		vo.add(linkTo(methodOn(CityController.class).findById(vo.getAddress().getCity().getKey())).withRel("City"));	
//		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getAddress().getCity().getProvince().getKey())).withRel("Province"));	
//		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country"));	
		return vo;
				
	}	
	
	@ApiOperation(value = "Find a Customer by name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CustomerVO> findByName(@PathVariable("name") String name) { 
		List<CustomerVO> list = service.findByName(name);
		list.forEach( customer -> customer.add(linkTo(methodOn(CustomerController.class).findById(customer.getKey())).withSelfRel()));	
//		list.forEach( customer -> customer.add(linkTo(methodOn(AddressController.class).findById(customer.getAddress().getKey())).withRel("Address")));
//		list.forEach( customer -> customer.add(linkTo(methodOn(CityController.class).findById(customer.getAddress().getCity().getKey())).withRel("City")));
//		list.forEach( customer -> customer.add(linkTo(methodOn(ProvinceController.class).findById(customer.getAddress().getCity().getProvince().getKey())).withRel("Province")));
//		list.forEach( customer -> customer.add(linkTo(methodOn(CountryController.class).findById(customer.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country")));
		return list;
				
	}	
	
	@ApiOperation(value = "Save a new Customer") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CustomerVO save(@RequestBody CustomerVO customerVO){
		CustomerVO vo = service.save(customerVO);
		vo.add(linkTo(methodOn(CustomerController.class).findById(vo.getKey())).withSelfRel());	
//		vo.add(linkTo(methodOn(AddressController.class).findById(vo.getAddress().getKey())).withRel("Address"));	
//		vo.add(linkTo(methodOn(CityController.class).findById(vo.getAddress().getCity().getKey())).withRel("City"));	
//		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getAddress().getCity().getProvince().getKey())).withRel("Province"));	
//		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country"));	
		return vo;
	}
	
	@ApiOperation(value = "Update a specific Customer")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CustomerVO update(@RequestBody CustomerVO customerVO){
		CustomerVO vo = service.update(customerVO);		
		vo.add(linkTo(methodOn(CustomerController.class).findById(vo.getKey())).withSelfRel());	
//		vo.add(linkTo(methodOn(AddressController.class).findById(vo.getAddress().getKey())).withRel("Address"));	
//		vo.add(linkTo(methodOn(CityController.class).findById(vo.getAddress().getCity().getKey())).withRel("City"));	
//		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getAddress().getCity().getProvince().getKey())).withRel("Province"));	
//		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country"));	
		return vo;
	}	
	
	@ApiOperation(value = "Delete a specific Customer by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}