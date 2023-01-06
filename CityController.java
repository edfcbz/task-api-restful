package br.com.edfcbz.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edfcbz.api.bean.vo.CityVO;
import br.com.edfcbz.api.bean.vo.CountryVO;
import br.com.edfcbz.api.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "CityEndpoint")
@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private CityService service;
	
	@Cacheable("city")
	@ApiOperation(value = "Find all Cities" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CityVO> findAll() throws Throwable {
			List<CityVO> list = service.findAll();
			list.forEach( p -> p.add(linkTo(methodOn(CityController.class).findById(p.getKey())).withSelfRel()));	
			list.forEach( p -> p.add(linkTo(methodOn(ProvinceController.class).findById(p.getProvince().getKey())).withRel("Province")));		
			list.forEach( p -> p.add(linkTo(methodOn(CountryController.class).findById(p.getProvince().getCountry().getKey())).withRel("Province")));
		return list;
	}	
	
	@ApiOperation(value = "Find a specific City by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public CityVO findById(@PathVariable("id") int id) {
		CityVO vo = service.findById(id);
		vo.add(linkTo(methodOn(CityController.class).findById(id)).withSelfRel());	
		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getProvince().getKey())).withRel("Province"));
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getProvince().getCountry().getKey())).withRel("Country"));
		return vo;
				
	}	
	
	@ApiOperation(value = "Find a City by name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CityVO> findByName(@PathVariable("name") String name) { 
		List<CityVO> list = service.findByName(name);
		list.forEach( p -> p.add(linkTo(methodOn(CityController.class).findById(p.getKey())).withSelfRel()));	
		list.forEach( p -> p.add(linkTo(methodOn(ProvinceController.class).findById(p.getProvince().getKey())).withRel("Province")));		
		list.forEach( p -> p.add(linkTo(methodOn(CountryController.class).findById(p.getProvince().getCountry().getKey())).withRel("Province")));		
		return list;
				
	}	
	
	@ApiOperation(value = "Save a new City") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CityVO save(@RequestBody CityVO cityVO) throws Throwable {
		CityVO vo = service.save(cityVO);
		vo.add(linkTo(methodOn(CityController.class).findById(vo.getKey())).withSelfRel());	
		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getProvince().getKey())).withRel("Province"));
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getProvince().getCountry().getKey())).withRel("Country"));		
		return vo;
	}
	
	@ApiOperation(value = "Update a specific City")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CityVO update(@RequestBody CityVO cityVO) throws Throwable {
		CityVO vo = service.update(cityVO);
		vo.add(linkTo(methodOn(CityController.class).findById(vo.getKey())).withSelfRel());
		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getProvince().getKey())).withRel("Province"));
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getProvince().getCountry().getKey())).withRel("Country"));
		return vo;
	}	
	
	@ApiOperation(value = "Delete a specific City by ID")
	@DeleteMapping("/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
	public CityVO delete(@PathVariable("id") Integer id) {
//		service.delete(id);
//		return ResponseEntity.ok().build();
		if (service.delete(id)==1) {
			return new CityVO();
		}else {
			return null;
		} 
		
		
	}	
	
}