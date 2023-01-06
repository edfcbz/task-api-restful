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

import br.com.edfcbz.api.bean.vo.ProductVO;
import br.com.edfcbz.api.bean.vo.StoreVO;
import br.com.edfcbz.api.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "ProductEndpoint")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Cacheable("product")
	@ApiOperation(value = "Find all Product" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<ProductVO> findAll(){
		List<ProductVO> list = service.findAll();
		list.forEach( p -> p.add(linkTo(methodOn(ProductController.class).findById(p.getKey())).withSelfRel()));		
		return list;
	}	
	
	@ApiOperation(value = "Find a specific Country by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ProductVO findById(@PathVariable("id") int id) {
		ProductVO vo = service.findById(id);
		vo.setStore(new StoreVO());
		vo.add(linkTo(methodOn(ProductController.class).findById(id)).withSelfRel());	
		return vo;
	}	
	
	@ApiOperation(value = "Find a Country by name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<ProductVO> findByName(@PathVariable("name") String name) { 
		List<ProductVO> list = service.findByName(name);
		list.forEach( p -> p.add(linkTo(methodOn(ProductController.class).findById(p.getKey())).withSelfRel()));	
		return list;
	}	
	
	@ApiOperation(value = "Save a new Cousine") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public ProductVO save(@RequestBody ProductVO productVO){
		ProductVO vo = service.save(productVO);
		vo.add(linkTo(methodOn(ProductController.class).findById(vo.getKey())).withSelfRel());	
		vo.add(linkTo(methodOn(StoreController.class).findById(productVO.getStore().getKey())).withRel("Store"));
		vo.setStore(productVO.getStore());
		vo.getStore().add(linkTo(methodOn(StoreController.class).findById(vo.getStore().getKey())).withRel("Supplier's link"));
		return vo;
	}
	
	@ApiOperation(value = "Update a specific Country")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public ProductVO update(@RequestBody ProductVO productVO){
		ProductVO vo = service.update(productVO);
		vo.add(linkTo(methodOn(ProductController.class).findById(vo.getKey())).withSelfRel());
		return vo;
	}	
	
	@ApiOperation(value = "Delete a specific Country by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}