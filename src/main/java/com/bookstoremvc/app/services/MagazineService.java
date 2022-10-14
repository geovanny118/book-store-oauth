package com.bookstoremvc.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstoremvc.app.entities.Magazine;
import com.bookstoremvc.app.repositories.IMagazineRepository;

@Service
public class MagazineService {
	
	@Autowired
	public IMagazineRepository magazineRepository;
	
	public Magazine create(Magazine magazine) {
		return magazineRepository.save(magazine);
	}
	
	public List<Magazine> getMagazines(){
		return magazineRepository.getAllMagazines();
	}
	
	public boolean delete(Magazine magazine) {
		try {
			magazineRepository.delete(magazine);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public Magazine getMagazine(int id) {
		return magazineRepository.findById(id).orElse(null);
	}
}
