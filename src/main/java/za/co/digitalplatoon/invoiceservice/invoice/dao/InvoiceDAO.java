package za.co.digitalplatoon.invoiceservice.invoice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import za.co.digitalplatoon.invoiceservice.invoice.model.Invoice;

@Repository
public class InvoiceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Invoice invoice) {
	entityManager.persist(invoice);
    }

    public Invoice update(Invoice invoice) {
	return invoice = entityManager.merge(invoice);
    }

    public Invoice getById(long id) {
	return entityManager.find(Invoice.class, id);
    }

    public void delete(long id) {
	Invoice invoice = getById(id);
	if (invoice != null) {
	    entityManager.remove(invoice);
	}
    }

    public List<Invoice> getAllInvoices() {
	// List<Invoice> results =
	// entityManager.createQuery("Select a from A a",
	// Invoice.class).getResultList();

	Query query = entityManager.createNamedQuery("findAllInvoices");
	List<Invoice> results = query.getResultList();
	return results;
    }

}
