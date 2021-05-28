package com.coda.springboot.shoppingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coda.springboot.shoppingapp.model.Invoice;

@Repository("invoiceRepository")
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{
	
	List<Invoice> findByInvid(String invid);
	
	List<Invoice> findAll();

}
