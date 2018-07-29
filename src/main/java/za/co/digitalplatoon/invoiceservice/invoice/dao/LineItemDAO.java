package za.co.digitalplatoon.invoiceservice.invoice.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import za.co.digitalplatoon.invoiceservice.invoice.model.LineItem;

@Repository
public class LineItemDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(LineItem lineItem) {
	entityManager.persist(lineItem);
    }

    public LineItem update(LineItem lineItem) {
	return entityManager.merge(lineItem);
    }

    public LineItem getById(long id) {
	return entityManager.find(LineItem.class, id);
    }

    public void delete(long id) {
	LineItem lineItem = getById(id);
	if (lineItem != null) {
	    entityManager.remove(lineItem);
	}
    }
}
