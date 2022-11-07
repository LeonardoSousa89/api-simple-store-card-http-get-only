package com.card.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.card.card.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long>{}
