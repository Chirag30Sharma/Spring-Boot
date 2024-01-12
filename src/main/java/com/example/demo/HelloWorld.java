package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/hello")
public class HelloWorld {
	@GetMapping("/world")
	public String get() {
		return "<b>Hello World</b>";
	}

	@GetMapping("/{name}")
	public String getMethodName(@PathVariable String name) {
		return name;
	}
	
	@PostMapping("/Enter")
	public String insert(@RequestBody Details ob) {		
		Details.arr1.add(new Details(ob.number, ob.name));
		for(Details obd: Details.arr1){
			System.out.println(obd.name + " " + obd.number);
		}
		return "Data Inserted";
	}
}		