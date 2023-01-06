package br.com.edfcbz.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.edfcbz.api.bean.vo.ProvinceVO;
import br.com.edfcbz.api.service.ProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "ProvinceEndpoint")
@RestController
@RequestMapping("/province")
public class ProvinceController {
	
	@Autowired
	private ProvinceService service;
	
	@ApiOperation(value = "Find all provincies" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<ProvinceVO> findAll() throws Throwable {
		List<ProvinceVO> list = service.findAll();
		list.forEach( p -> p.add(linkTo(methodOn(ProvinceController.class).findById(p.getKey())).withSelfRel()) );
		list.forEach( p -> p.add(linkTo(methodOn(CountryController.class).findById(p.getCountry().getKey())).withRel("Country")));
		return list;
	}	
	
	@ApiOperation(value = "Find a specific Province by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ProvinceVO findById(@PathVariable("id") int id) {
		ProvinceVO vo = service.findById(id);
		vo.add(linkTo(methodOn(ProvinceController.class).findById(id)).withSelfRel());	
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getCountry().getKey())).withRel("Country"));	
		return vo;
				
	}	
	
	@ApiOperation(value = "Find a specific Province by your ID" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<ProvinceVO> findByName(@PathVariable("name") String name) { 
		List<ProvinceVO> list = service.findByName(name);
		list.forEach( p -> p.add(linkTo(methodOn(ProvinceController.class).findById(p.getKey())).withSelfRel()) );
		list.forEach( p -> p.add(linkTo(methodOn(CountryController.class).findById(p.getCountry().getKey())).withRel("Country")));	
		return list;
				
	}	
	
	@ApiOperation(value = "Save a new Province") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public ProvinceVO save(@RequestBody ProvinceVO provinceVO) throws Throwable {
		ProvinceVO vo = service.save(provinceVO);
		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getKey())).withSelfRel());	
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getCountry().getKey())).withRel("Country"));	
		return vo;
	}
	
	@ApiOperation(value = "Update a specific Province")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public ProvinceVO update(@RequestBody ProvinceVO countryVO) throws Throwable {
		ProvinceVO vo = service.update(countryVO);
		vo.add(linkTo(methodOn(ProvinceController.class).findById(vo.getKey())).withSelfRel());	
		vo.add(linkTo(methodOn(CountryController.class).findById(vo.getCountry().getKey())).withRel("Country"));	
		return vo;
	}	
	
	@ApiOperation(value = "Delete a specific Province by ID")
	@DeleteMapping("/{id}")
//	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
	public ProvinceVO delete(@PathVariable("id") Integer id) {
//		service.delete(id);
//		return ResponseEntity.ok().build();
		if (service.delete(id)==1) {
			return new ProvinceVO();
		}else {
			return null;
		} 
		
		
	}	
	
}