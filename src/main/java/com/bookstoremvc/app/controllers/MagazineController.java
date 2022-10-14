package com.bookstoremvc.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoremvc.app.entities.Magazine;
import com.bookstoremvc.app.services.MagazineService;

@RestController
@RequestMapping("/api/magazine")
public class MagazineController {
	@Autowired
	MagazineService magazineService;
	
	@PostMapping("/add")
	public Magazine addMagazine(@RequestBody Magazine magazine) {
		return magazineService.create(magazine);
	}
	
	@GetMapping("/list")
	public List<Magazine> listMagazines() {
		return magazineService.getMagazines();
	}
	
	@DeleteMapping("/delete")
	public boolean deleteMagazine(@RequestBody Magazine magazine) {
		return magazineService.delete(magazine);
	}
	
	@PutMapping("/update")
	public Magazine updateMagazine(@RequestBody Magazine magazine) {
		return magazineService.create(magazine); 
	}
	
	@GetMapping("/search")
	public Magazine getMagazine(int id) {
		return magazineService.getMagazine(id);
	}
}
