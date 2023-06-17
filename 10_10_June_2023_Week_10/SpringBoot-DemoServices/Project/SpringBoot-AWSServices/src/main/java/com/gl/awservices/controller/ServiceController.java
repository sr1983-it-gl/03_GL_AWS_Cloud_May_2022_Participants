package com.gl.awservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gl.awservices.entity.ServiceEntity;
import com.gl.awservices.repository.ServiceRepository;

@Controller
public class ServiceController {

	private ServiceRepository repository = new ServiceRepository();
	
	@GetMapping("/services")
	public String getAll(Model model) {
		try {
			List<ServiceEntity> services = repository.listAll();
			model.addAttribute("services", services);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "services";
	}

}
