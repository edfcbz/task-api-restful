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

import br.com.edfcbz.api.bean.vo.OrderStatusVO;
import br.com.edfcbz.api.service.OrderStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "OrderStatusEndpoint")
@RestController
@RequestMapping("/orderStatus")
public class OrderStatusController {
	
	@Autowired
	private OrderStatusService service;
	
	@ApiOperation(value = "Find all OrderStatus" ) 
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<OrderStatusVO> findAll(){
		List<OrderStatusVO> list = service.findAll();
		list.forEach( p -> p.add(linkTo(methodOn(OrderStatusController.class).findById(p.getKey())).withSelfRel()));
		list.forEach( p -> p.getOrder().add(linkTo(methodOn(OrderController.class).findById(p.getKey())).withRel("Order")));
		list.forEach( p -> p.getOrder().getCustomer().add(linkTo(methodOn(CustomerController.class).findById(p.getKey())).withRel("Customer")));
		return list;
	}	
	
	@ApiOperation(value = "Find a specific OrderStatus by your ID" )
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public OrderStatusVO findById(@PathVariable("id") int id) {
		OrderStatusVO orderStatusVO = service.findById(id);
		orderStatusVO.add(linkTo(methodOn(OrderStatusController.class).findById(id)).withSelfRel());
		orderStatusVO.add(linkTo(methodOn(OrderController.class).findById(orderStatusVO.getKey())).withRel("Order"));
		orderStatusVO.add(linkTo(methodOn(CustomerController.class).findById(orderStatusVO.getKey())).withRel("Customer"));
		return orderStatusVO;
				
	}	
	
	@ApiOperation(value = "Find a OrderStatus by name" )
	@GetMapping(value = "/order/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public OrderStatusVO findByOrderId(@PathVariable("id") int id) { 
		OrderStatusVO orderStatusVO = service.findByOrderId(id).get(0);
		orderStatusVO.add(linkTo(methodOn(OrderStatusController.class).findById(id)).withSelfRel());
		orderStatusVO.add(linkTo(methodOn(OrderController.class).findById(orderStatusVO.getKey())).withRel("Order"));
		orderStatusVO.add(linkTo(methodOn(CustomerController.class).findById(orderStatusVO.getKey())).withRel("Customer"));
		return orderStatusVO;
				
	}	
	
	@ApiOperation(value = "Save a new City") 
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public OrderStatusVO save(@RequestBody OrderStatusVO orderStatusVO){
		orderStatusVO = service.save(orderStatusVO);
		orderStatusVO.add(linkTo(methodOn(OrderStatusController.class).findById(orderStatusVO.getKey())).withSelfRel());	
		orderStatusVO.add(linkTo(methodOn(OrderController.class).findById(orderStatusVO.getKey())).withRel("Order"));
		orderStatusVO.add(linkTo(methodOn(CustomerController.class).findById(orderStatusVO.getKey())).withRel("Customer"));		
		return orderStatusVO;
	}
	
	@ApiOperation(value = "Update a specific City")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, 
			consumes = { "application/json", "application/xml", "application/x-yaml" })
	public OrderStatusVO update(@RequestBody OrderStatusVO orderStatusVO){
		orderStatusVO = service.update(orderStatusVO);
		orderStatusVO.add(linkTo(methodOn(OrderStatusController.class).findById(orderStatusVO.getKey())).withSelfRel());
		orderStatusVO.add(linkTo(methodOn(OrderController.class).findById(orderStatusVO.getKey())).withRel("Order"));
		orderStatusVO.add(linkTo(methodOn(CustomerController.class).findById(orderStatusVO.getKey())).withRel("Customer"));		
		return orderStatusVO;
	}	
	
	@ApiOperation(value = "Delete a specific OrderStatus by ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
	
}