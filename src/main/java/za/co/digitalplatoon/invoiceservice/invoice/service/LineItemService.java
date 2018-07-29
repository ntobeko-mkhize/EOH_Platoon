package za.co.digitalplatoon.invoiceservice.invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.digitalplatoon.invoiceservice.invoice.dao.LineItemDAO;
import za.co.digitalplatoon.invoiceservice.invoice.model.LineItem;

@Service
public class LineItemService {
    @Autowired
    private LineItemDAO lineItemDAO;

    public void create(LineItem lineItem) throws Exception {
	lineItemDAO.create(lineItem);
    }

    public LineItem update(LineItem lineItem) throws Exception {
	return lineItemDAO.update(lineItem);
    }

    public LineItem getById(LineItem lineItem) throws Exception {
	return lineItemDAO.update(lineItem);
    }

    public void delete(LineItem lineItem) throws Exception {
	lineItemDAO.update(lineItem);
    }
}
