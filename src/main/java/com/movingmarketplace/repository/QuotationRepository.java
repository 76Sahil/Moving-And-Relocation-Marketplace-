package com.movingmarketplace.repository;

import com.movingmarketplace.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation, Long>{

}