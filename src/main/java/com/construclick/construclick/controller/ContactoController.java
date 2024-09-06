package com.construclick.construclick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construclick.construclick.model.Contacto;
import com.construclick.construclick.service.ContactoService;

	

@RestController
@RequestMapping("/contacto/v1")
public class ContactoController {
		
	private ContactoService contactoService;
		
		@Autowired 
		public ContactoController(ContactoService contactoService) {
			this.contactoService = contactoService;	
		}
		//mapear metodos
		@GetMapping("/registros")
		public List<Contacto> getMappingAll(){
			return contactoService.getAll();	
		}
		
		@PostMapping
		public Contacto newContacto(@RequestBody Contacto contacto) {
			return contactoService.createContacto(contacto);
		}
		
		//Mapear método delete que apunte a un Id específico. Para ello, debemos permitir que el Id sea variable en el endpoint (@PathVariable)
		@DeleteMapping("/registros/{id}")
		public void detelerContacto(@PathVariable(name = "id") Long id) {
			contactoService.deleteContacto(id);
		}
		
		@GetMapping("/registros/{id}")
		public Contacto getById(@PathVariable(name = "id") Long id) {
			return contactoService.getById(id);
		}
		

}