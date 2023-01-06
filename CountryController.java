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

import br.com.edfcbz.api.bean.vo.CountryVO;
import br.com.edfcbz.api.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "CountryEndpoint")
@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	private CountryService service;
	
	@Cacheable("country")
	@ApiOperation(value = "Find all Countries" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CountryVO> findAll(){
		List<CountryVO> list = service.findAll();
		list.forEach( p -> p.add(linkTo(methodOn(CountryController.class).findById(p.getKey())).withSelfRel()));	
		return list;
	}	
	
	@ApiOperation(value = "Find specific Country by ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public CountryVO findById(@PathVariable("id") int id) {
		CountryVO vo = service.findById(id);
		vo.add(linkTo(methodOn(CountryController.class).findById(id)).withSelfRel());	
		return vo;
				
	}	
	
	@ApiOperation(value = "Find Countries by name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CountryVO> findByName(@PathVariable("name") String name) { 
		List<CountryVO> list = service.findByName(name);
		list.forEach( p -> p.add(linkTo(methodOn(CountryController.class).findById(p.getKey())).withSelfRel()));	
		return list;
				
	}	
	
	@ApiOperation(value = "Save a new Country") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CountryVO save(@RequestBody CountryVO countryVO){
		CountryVO vo = service.save(countryVO);
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getKey())).withSelfRel());	
		return vo;
	}
	
	@ApiOperation(value = "Update a specific Country")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CountryVO update(@RequestBody CountryVO countryVO){
		CountryVO vo = service.update(countryVO);
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}	
	
	@ApiOperation(value = "Delete a specific Country by ID")
	@DeleteMapping("/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
	public CountryVO delete(@PathVariable("id") Integer id) {
//		service.delete(id);
//		return ResponseEntity.ok().build();
		if (service.delete(id)==1) {
			return new CountryVO();
		}else {
			return null;
		} 
		
		
	}	
	
}