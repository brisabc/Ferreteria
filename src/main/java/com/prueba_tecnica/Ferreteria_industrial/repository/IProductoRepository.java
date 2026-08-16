package com.prueba_tecnica.Ferreteria_industrial.repository;

import com.prueba_tecnica.Ferreteria_industrial.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
