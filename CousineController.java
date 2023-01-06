package br.com.edfcbz.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.edfcbz.api.bean.vo.CousineVO;
import br.com.edfcbz.api.service.CousineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "CousineEndpoint")
@RestController
@RequestMapping("/cousine")
public class CousineController {
	
	@Autowired
	private CousineService service;
	
	@Cacheable("cousine")
	@ApiOperation(value = "Find all Cousine" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CousineVO> findAll(){
		List<CousineVO> list = service.findAll();
		list.forEach( p -> p.add(linkTo(methodOn(CousineController.class).findById(p.getKey())).withSelfRel()));	
		return list;
	}	
	
	@ApiOperation(value = "Find a specific Country by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public CousineVO findById(@PathVariable("id") int id) {
		CousineVO vo = service.findById(id);
		vo.add(linkTo(methodOn(CousineController.class).findById(id)).withSelfRel());	
		return vo;
				
	}	
	
	@ApiOperation(value = "Find a Country by name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<CousineVO> findByName(@PathVariable("name") String name) { 
		List<CousineVO> list = service.findByName(name);
		list.forEach( p -> p.add(linkTo(methodOn(CousineController.class).findById(p.getKey())).withSelfRel()));	
		return list;
				
	}	
	
	@ApiOperation(value = "Save a new Cousine") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CousineVO save(@RequestBody CousineVO cousineVO){
		CousineVO vo = service.save(cousineVO);
		vo.add(linkTo(methodOn(CousineController.class).findById(vo.getKey())).withSelfRel());	
		return vo;
	}
	
	@ApiOperation(value = "Update a specific Country")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public CousineVO update(@RequestBody CousineVO cousineVO){
		CousineVO vo = service.update(cousineVO);
		vo.add(linkTo(methodOn(CousineController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}	
	
	@ApiOperation(value = "Delete a specific Country by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}