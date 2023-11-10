package com.example.demo.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.business.abstracts.ModelDetailsService;
import com.example.demo.business.requests.UpdateModelDetailsRequest;
import com.example.demo.business.requests.UpdateSingleModelDetailsRequest;
import com.example.demo.business.responses.GetAllModelDetailsResponse;
import com.example.demo.business.responses.GetByIdModelDetailsResponse;

@RestController
@RequestMapping("/api/modeldetails")
public class ModelDetailsController {
	@Autowired
	private ModelDetailsService modelDetailsService;
	@GetMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	private List<GetAllModelDetailsResponse> getAll(){
		return modelDetailsService.getAll();
	}
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	private GetByIdModelDetailsResponse getById(@PathVariable int id) {
		return modelDetailsService.getByIdModelDetails(id);
	}
	
	@PutMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	private void update(@RequestBody() UpdateModelDetailsRequest updateModelDetailsRequest) {
		modelDetailsService.update(updateModelDetailsRequest);
	}
	
	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	private void updateSingleAttribute(@RequestBody UpdateSingleModelDetailsRequest updateSingleModelDetailsRequest) {
		modelDetailsService.updateSingleAttribute(updateSingleModelDetailsRequest);
	}
	
	@PostMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	private void delete(@PathVariable int id) {
		modelDetailsService.delete(id);
	}
}
