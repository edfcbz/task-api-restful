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

import br.com.edfcbz.api.bean.converter.DozerConverter;
import br.com.edfcbz.api.bean.vo.AddressVO;
import br.com.edfcbz.api.bean.vo.OrderItemVO;
import br.com.edfcbz.api.bean.vo.OrderVO;
import br.com.edfcbz.api.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "OrderEndpoint")
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@Autowired 
	ProductController productController;
	
	@Cacheable("order")
	@ApiOperation(value = "Find all Order" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<OrderVO> findAll(){
		List<OrderVO> list = service.findAll();
		list.stream().forEach( p -> p.add(linkTo(methodOn(OrderController.class).findById(p.getKey())).withSelfRel()));	
		list.stream().forEach( p -> p.getCustomer().add(linkTo(methodOn(CustomerController.class).findById(p.getCustomer().getKey())).withRel("Customer's link")));	
		list.stream().forEach( p -> addLink(p));
		return list;
	}	
	
	@ApiOperation(value = "Find a specific Order by ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public OrderVO findById(@PathVariable("id") int id) {
		OrderVO orderVO = service.findById(id);
		orderVO.add(linkTo(methodOn(OrderController.class).findById(id)).withSelfRel());	
		orderVO.getCustomer().add(linkTo(methodOn(CustomerController.class).findById(id)).withRel("Customer's link"));
		addLink(orderVO);
		return orderVO;
	}	
	
	public void addLink(OrderVO vo) {
		List<OrderItemVO> listVO = vo.getListItem();
		for (OrderItemVO orderItemVO : listVO) {
			orderItemVO.add(linkTo(methodOn(ProductController.class).findById(orderItemVO.getProduct().getKey())).withRel("Product's link"));
			//orderItemVO.getProduct().add(linkTo(methodOn(ProductController.class).findById(orderItemVO.getProduct().getKey())).withRel("Product's link"));
		}
		
	}
	
	@ApiOperation(value = "Find a Order by Customer's name" )
	@GetMapping(value = "/name/{name}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<OrderVO> findByName(@PathVariable("name") String name) { 
		List<OrderVO> list = service.findByName(name);
		list.stream().forEach( p -> p.add(linkTo(methodOn(OrderController.class).findById(p.getKey())).withSelfRel()));	
		list.stream().forEach( p -> p.add(linkTo(methodOn(CustomerController.class).findById(p.getCustomer().getKey())).withRel("Customer's link")));	
		list.stream().forEach( p -> addLink(p));	
		return list;
				
	}	
	
	@ApiOperation(value = "Save a new Order") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public OrderVO save(@RequestBody OrderVO orderVO){
		orderVO = service.save(orderVO);
		orderVO.add(linkTo(methodOn(OrderController.class).findById(orderVO.getKey())).withSelfRel());	
		orderVO.add(linkTo(methodOn(CustomerController.class).findById(orderVO.getKey())).withRel("Customer's link"));
		addLink(orderVO);	
		return orderVO;
	}
	
	@ApiOperation(value = "Update a specific Order")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public OrderVO update(@RequestBody OrderVO orderVO){
		orderVO = service.update(orderVO);
		orderVO.add(linkTo(methodOn(OrderController.class).findById(orderVO.getKey())).withSelfRel());	
		orderVO.add(linkTo(methodOn(CustomerController.class).findById(orderVO.getKey())).withRel("Customer's link"));
		addLink(orderVO);	
		return orderVO;
	}	
	
	@ApiOperation(value = "Delete a specific Order by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}