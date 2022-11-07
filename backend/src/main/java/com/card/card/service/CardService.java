package com.card.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.card.card.entities.Card;
import com.card.card.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	CardRepository repository;
			
		/*CRUD*/
	
	/*ready*/
	@Transactional
	public List<Card> getData(){
		List<Card> card = repository.findAll();
		return card;
	}
	/*ready*/
	
	/*create*/
	@Transactional
	public Card insert(Card obj) {
		return repository.save(obj); 
	}
	/*create*/
	
	/*delete*/
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	/*delete*/
	
	/*update*/
	// faz parte do metodo update
	//o metodo get one monitora o objeto pelo 
	//jpa para após realizar uma transação com este objeto.
	@Transactional
	public Card update(Long id, Card obj) {
		Card entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	// faz parte do metodo update
	private void updateData(Card entity, Card obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setdescricao(obj.getdescricao());
		entity.setPreco(obj.getPreco());
	}
	/*update*/
}
