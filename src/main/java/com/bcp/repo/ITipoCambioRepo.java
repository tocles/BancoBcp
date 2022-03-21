package com.bcp.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.bcp.model.TipoCambio;


@Component
public interface ITipoCambioRepo  extends JpaRepository<TipoCambio, Long> {
 
	// Optional<TipoCambio> buscarPorMoneda(String monedaDestino);
}
