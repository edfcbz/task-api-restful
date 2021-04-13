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

import br.com.edfcbz.api.bean.vo.CourrierVO;
import br.com.edfcbz.api.bean.vo.ProductVO;
import br.com.edfcbz.api.service.CourrierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "CourrierEndpoint")
@RestController
@RequestMapping("/courrier")
public class CourrierController {
	
	@Autowired
	private CourrierService service;
	
	@ApiOperation(value = "Find all Courriers" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CourrierVO> findAll(){
		List<CourrierVO> list = service.findAll();
		list.forEach( courrier -> courrier.add(linkTo(methodOn(CourrierController.class).findById(courrier.getKey())).withSelfRel()));	
		list.forEach( courrier -> courrier.add(linkTo(methodOn(AddressController.class).findById(courrier.getAddress().getKey())).withRel("Address")));
		list.forEach( courrier -> courrier.add(linkTo(methodOn(CityController.class).findById(courrier.getAddress().getCity().getKey())).withRel("City")));
		list.forEach( courrier -> courrier.add(linkTo(methodOn(ProvinceController.class).findById(courrier.getAddress().getCity().getProvince().getKey())).withRel("Province")));
		list.forEach( courrier -> courrier.add(linkTo(methodOn(CountryController.class).findById(courrier.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country")));
		return list;
	}	
	
	@ApiOperation(value = "Find a specific Courrier by ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public CourrierVO findById(@PathVariable("id") int id) {
		CourrierVO vo = service.findById(id);
		vo.add(linkTo(methodOn(CourrierController.class).findById(vo.getKey())).withSelfRel());	
		vo.add(linkTo(methodOn(AddressController.class).findById(vo.getAddress().getKey())).withRel("Address"));	
		vo.add(linkTo(methodOn(CityController.class).findById(vo.getAddress().getCity().getKey())).withRel("City"));	
		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getAddress().getCity().getProvince().getKey())).withRel("Province"));	
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country"));	
		return vo;
				
	}	
	
	@ApiOperation(value = "Find a Courrier by name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CourrierVO> findByName(@PathVariable("name") String name) { 
		List<CourrierVO> list = service.findByName(name);
		list.forEach( courrier -> courrier.add(linkTo(methodOn(CourrierController.class).findById(courrier.getKey())).withSelfRel()));	
		list.forEach( courrier -> courrier.add(linkTo(methodOn(AddressController.class).findById(courrier.getAddress().getKey())).withRel("Address")));
		list.forEach( courrier -> courrier.add(linkTo(methodOn(CityController.class).findById(courrier.getAddress().getCity().getKey())).withRel("City")));
		list.forEach( courrier -> courrier.add(linkTo(methodOn(ProvinceController.class).findById(courrier.getAddress().getCity().getProvince().getKey())).withRel("Province")));
		list.forEach( courrier -> courrier.add(linkTo(methodOn(CountryController.class).findById(courrier.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country")));
		return list;
				
	}	
	
	@ApiOperation(value = "Save a new Courrier") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CourrierVO save(@RequestBody CourrierVO courrierVO){
		CourrierVO vo = service.save(courrierVO);
		vo.add(linkTo(methodOn(CourrierController.class).findById(vo.getKey())).withSelfRel());	
		vo.add(linkTo(methodOn(AddressController.class).findById(vo.getAddress().getKey())).withRel("Address"));	
		vo.add(linkTo(methodOn(CityController.class).findById(vo.getAddress().getCity().getKey())).withRel("City"));	
		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getAddress().getCity().getProvince().getKey())).withRel("Province"));	
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country"));	
		return vo;
	}
	
	@ApiOperation(value = "Update a specific Courrier")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CourrierVO update(@RequestBody CourrierVO courrierVO){
		CourrierVO vo = service.update(courrierVO);		
		vo.add(linkTo(methodOn(CourrierController.class).findById(vo.getKey())).withSelfRel());	
		vo.add(linkTo(methodOn(AddressController.class).findById(vo.getAddress().getKey())).withRel("Address"));	
		vo.add(linkTo(methodOn(CityController.class).findById(vo.getAddress().getCity().getKey())).withRel("City"));	
		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getAddress().getCity().getProvince().getKey())).withRel("Province"));	
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country"));	
		return vo;
	}	
	
	@ApiOperation(value = "Delete a specific Courrier by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}