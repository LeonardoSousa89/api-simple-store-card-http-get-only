package com.card.card.Controllers;

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

import com.card.card.entities.Card;
import com.card.card.service.CardService;

@RestController
@RequestMapping(value="/card")
public class CardController {
	
	@Autowired
	CardService service;
	
		/*CRUD*/
	
	   /*ready*/
		@GetMapping
		public ResponseEntity<List<Card>> getCard(){
			List<Card> card = service.getData();
			return ResponseEntity.ok().body(card);
		}
		/*ready*/
		
		/*create*/
		@PostMapping(value="/insert")
		public ResponseEntity<Card>insert(@RequestBody Card obj){
			Card card = service.insert(obj);
			return ResponseEntity.ok().body(card);
		}
		/*create*/
		
		/*delete*/
		@DeleteMapping(value="/delete/{id}")
		public ResponseEntity<Void> delete(@PathVariable Long id) {
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		/*delete*/
		
		/*update*/
		@PutMapping(value="/update/{id}")
		public ResponseEntity<Card> update(@PathVariable Long id, @RequestBody Card obj){
			Card card = service.update(id, obj);
			return ResponseEntity.ok().body(card);
		}
		/*update*/
			
}
