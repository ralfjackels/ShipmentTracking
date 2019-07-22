package com.dhl_miniprojekt.repositories;

import com.dhl_miniprojekt.entities.Sendung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendungsRepository extends JpaRepository<Sendung, Integer> {
}
