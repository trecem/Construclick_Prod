package com.construclick.construclick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construclick.construclick.exceptions.ContactoNotFoundException;
import com.construclick.construclick.model.Contacto;

import com.construclick.construclick.repository.ContactoRepository;



@Transactional
@Service
public class ContactoService {
	
	//Mando a llamar UserRepository
			private final ContactoRepository contactoRepository;
			
			
			//Inyección de dependencias en el constructos
			@Autowired
			public ContactoService(ContactoRepository contactoRepository) {
				super();
				this.contactoRepository = contactoRepository;
			}
			
			// Método para obtener todos los usuarios
			public List<Contacto> getAll(){
				return contactoRepository.findAll();
			}
			
			//Método para crear un nuevo usuario
			public Contacto createContacto(Contacto newContacto) {
				return contactoRepository.save(newContacto);
			}
			
			//Método para eliminar un nuevo mensaje mediante id
			public void deleteContacto(Long id) {
				if (contactoRepository.existsById(id)) {
					contactoRepository.deleteById(id);
				} else {
					throw new ContactoNotFoundException(id);
				}
			}
			
			// Método para recuperar usuarios por Id (validar si existe)
			public Contacto getById(Long id) {
				return contactoRepository.findById(id)
						.orElseThrow(() -> new ContactoNotFoundException(id));
			}
			
			

}
