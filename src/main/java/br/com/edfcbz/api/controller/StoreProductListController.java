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

import br.com.edfcbz.api.bean.vo.StoreProductListVO;
import br.com.edfcbz.api.exception.OperationException;
import br.com.edfcbz.api.service.StoreProductListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "ProductStoreEndpoint")
@RestController
@RequestMapping("/storehasproduct")
public class StoreProductListController {
	
	@Autowired
	private StoreProductListService service;
	
	@ApiOperation(value = "Find all ProductStore" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<StoreProductListVO> findAll(){
		List<StoreProductListVO> list = service.findAll();
		list.forEach( p -> p.add(linkTo(methodOn(StoreProductListController.class).findById(p.getKey())).withSelfRel()));	
		list.forEach( p -> p.getStore().add(linkTo(methodOn(StoreController.class).findById(p.getKey())).withRel("Store link")));
		list.forEach( p -> p.getProducts().forEach( s -> s.add(linkTo(methodOn(ProductController.class).findById(s.getKey())).withRel("Product link"))));
		return list;
	}	
	
	@SuppressWarnings("finally")
	@ApiOperation(value = "Find a specific Country by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public StoreProductListVO findById(@PathVariable("id") int id) {
		try {
//			StoreProductListVO vo = service.findById(id);
//			vo.add(linkTo(methodOn(ProductStoreListController.class).findById(id)).withSelfRel()); 	
//			return vo;
//			
		} finally {
			throw new OperationException("Operation not supported yet. Wait for development");
		}
		
	}
	
	@ApiOperation(value = "Find a specific Country by your ID" )
	@GetMapping(value = "/storename/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public StoreProductListVO findByStoreName(@PathVariable("name") String name) {
		StoreProductListVO vo = service.findByStoreName(name);
		vo.add(linkTo(methodOn(ProductStoreListController.class).findByDescription(name)).withSelfRel()); 	
	
		vo.getStore().add(linkTo(methodOn(StoreController.class).findById(vo.getStore().getKey())).withRel("Store link"));
		vo.getProducts().forEach( s -> s.add(linkTo(methodOn(ProductController.class).findById(s.getKey())).withRel("Product link")));
		
		return vo;
	}	
	
	@ApiOperation(value = "Find a specific Country by your ID" )
	@GetMapping(value = "/storeid/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public StoreProductListVO findByStoreId(@PathVariable("id") int id) {
		StoreProductListVO vo = service.findByStoreId(id);
		vo.add(linkTo(methodOn(ProductStoreListController.class).findById(id)).withSelfRel()); 		
		vo.getStore().add(linkTo(methodOn(StoreController.class).findById(vo.getStore().getKey())).withRel("Store link"));
		vo.getProducts().forEach( s -> s.add(linkTo(methodOn(ProductController.class).findById(s.getKey())).withRel("Product link")));
		
		return vo;
	}	
	
	@SuppressWarnings("finally")
	@ApiOperation(value = "Update a specific Country")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public StoreProductListVO update(@RequestBody StoreProductListVO productStoreListVO){
		try {
//		StoreProductListVO vo = service.update(productStoreListVO);
//		vo.add(linkTo(methodOn(ProductStoreListController.class).findById(vo.getKey())).withSelfRel());
//			
		} finally {
			throw new OperationException("Operation not supported yet. Wait for development");
		}
	}	
	
	@SuppressWarnings("finally")
	@ApiOperation(value = "Delete a specific Country by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {

		
		try {
//			service.delete(id);
			//return ResponseEntity.ok().build();
			} finally {
				throw new OperationException("Operation not supported yet. Wait for development");
			}		
		
		
	}	
	
}