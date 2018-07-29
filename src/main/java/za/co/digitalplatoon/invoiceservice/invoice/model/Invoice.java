package za.co.digitalplatoon.invoiceservice.invoice.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
@NamedQuery(query = "Select inv from Invoice inv", name = "findAllInvoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String client;
    private Long vatRate;
    private Date invoiceDate;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getClient() {
	return client;
    }

    public void setClient(String client) {
	this.client = client;
    }

    public Long getVatRate() {
	return vatRate;
    }

    public void setVatRate(Long vatRate) {
	this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
	return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
	this.invoiceDate = invoiceDate;
    }

    public BigDecimal getSubTotal() {
	return null;

    }

    public BigDecimal getVat() {
	return null;

    }

    public BigDecimal getTotal() {
	return null;

    }

}
