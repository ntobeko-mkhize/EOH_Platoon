package za.co.digitalplatoon.invoiceservice.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.digitalplatoon.invoiceservice.invoice.dao.InvoiceDAO;
import za.co.digitalplatoon.invoiceservice.invoice.model.Invoice;

@Service
@Transactional
public class InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    public List<Invoice> getAllInvoices() throws Exception {
	return invoiceDAO.getAllInvoices();
    }

    public void create(Invoice invoice) throws Exception {
	invoiceDAO.create(invoice);
    }

    public Invoice update(Invoice invoice) throws Exception {
	return invoiceDAO.update(invoice);
    }

    public Invoice getById(int id) throws Exception {
	return invoiceDAO.getById(id);
    }

    public void delete(Invoice invoice) throws Exception {
	invoiceDAO.update(invoice);
    }
}