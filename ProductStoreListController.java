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

import br.com.edfcbz.api.bean.vo.ProductStoreListVO;
import br.com.edfcbz.api.service.ProductStoreListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "ProductStoreEndpoint")
@RestController
@RequestMapping("/producthasstore")
public class ProductStoreListController {
	
	@Autowired
	private ProductStoreListService service;
	
	@Cacheable("producthasstore")
	@ApiOperation(value = "Find all ProductStore" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<ProductStoreListVO> findAll(){
		List<ProductStoreListVO> list = service.findAll();
		list.forEach( p -> p.add(linkTo(methodOn(ProductStoreListController.class).findById(p.getKey())).withSelfRel()));	
		list.forEach( p -> p.getProduct().add(linkTo(methodOn(ProductController.class).findById(p.getKey())).withRel("Product link")));
		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(StoreController.class).findById(s.getKey())).withRel("Store link"))));
		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(AddressController.class).findById(s.getAddress().getKey())).withRel("Address link"))));
		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(CityController.class).findById(s.getAddress().getCity().getKey())).withRel("City link"))));
		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(ProvinceController.class).findById(s.getAddress().getCity().getProvince().getKey())).withRel("Province link"))));
		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(CountryController.class).findById(s.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country link"))));
		return list;
	}	
	
	@ApiOperation(value = "Find a specific Country by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ProductStoreListVO findById(@PathVariable("id") int id) {
		ProductStoreListVO vo = service.findById(id);
		vo.add(linkTo(methodOn(ProductStoreListController.class).findById(id)).withSelfRel()); 	
		return vo;
	}
	
	@ApiOperation(value = "Find a specific Country by your ID" )
	@GetMapping(value = "/productname/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public ProductStoreListVO findByDescription(@PathVariable("name") String name) {
		ProductStoreListVO vo = service.findByDescription(name);
		vo.add(linkTo(methodOn(ProductStoreListController.class).findByDescription(name)).withSelfRel()); 	
	
		vo.getProduct().add(linkTo(methodOn(ProductController.class).findById(vo.getKey())).withRel("Product link"));
		vo.getStores().forEach( s -> s.add(linkTo(methodOn(StoreController.class).findById(s.getKey())).withRel("Store link")));
		vo.getStores().forEach( s -> s.add(linkTo(methodOn(AddressController.class).findById(s.getAddress().getKey())).withRel("Address link")));
		vo.getStores().forEach( s -> s.add(linkTo(methodOn(CityController.class).findById(s.getAddress().getCity().getKey())).withRel("City link")));
		vo.getStores().forEach( s -> s.add(linkTo(methodOn(ProvinceController.class).findById(s.getAddress().getCity().getProvince().getKey())).withRel("Province link")));
		vo.getStores().forEach( s -> s.add(linkTo(methodOn(CountryController.class).findById(s.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country link")));		
		
		return vo;
	}	
	
	@ApiOperation(value = "Find a Country by name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<ProductStoreListVO> findByName(@PathVariable("name") String name) { 
//		List<ProductStoreListVO> list = service.findByName(name);
//		list.forEach( p -> p.add(linkTo(methodOn(ProductStoreListController.class).findById(p.getKey())).withSelfRel()));	
//		list.forEach( p -> p.getProduct().add(linkTo(methodOn(ProductController.class).findById(p.getKey())).withRel("Product link")));
//		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(StoreController.class).findById(s.getKey())).withRel("Store link"))));
//		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(AddressController.class).findById(s.getAddress().getKey())).withRel("Address link"))));
//		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(CityController.class).findById(s.getAddress().getCity().getKey())).withRel("City link"))));
//		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(ProvinceController.class).findById(s.getAddress().getCity().getProvince().getKey())).withRel("Province link"))));
//		list.forEach( p -> p.getStores().forEach( s -> s.add(linkTo(methodOn(CountryController.class).findById(s.getAddress().getCity().getProvince().getCountry().getKey())).withRel("Country link"))));
//		return list;
		return null;
	}	
	
	@ApiOperation(value = "Save a new Cousine") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public ProductStoreListVO save(@RequestBody ProductStoreListVO productStoreListVO){
//		ProductStoreListVO vo = service.save(productStoreListVO);
//		vo.add(linkTo(methodOn(ProductStoreListController.class).findById(vo.getKey())).withSelfRel());	
//		vo.add(linkTo(methodOn(StoreController.class).findById(productStoreListVO.getStore().getKey())).withRel("Store"));
//		vo.setStore(productStoreListVO.getStore());
//		vo.getStore().add(linkTo(methodOn(StoreController.class).findById(vo.getStore().getKey())).withRel("Supplier's link"));
		return null;// vo;
	}
	
	@ApiOperation(value = "Update a specific Country")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public ProductStoreListVO update(@RequestBody ProductStoreListVO productStoreListVO){
//		ProductStoreListVO vo = service.update(productStoreListVO);
//		vo.add(linkTo(methodOn(ProductStoreListController.class).findById(vo.getKey())).withSelfRel());
		return null;// vo;
	}	
	
	@ApiOperation(value = "Delete a specific Country by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}