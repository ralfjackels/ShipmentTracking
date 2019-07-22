package com.dhl_miniprojekt.repositories;

import com.dhl_miniprojekt.entities.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundeRepository extends JpaRepository<Kunde, Integer> {
}
