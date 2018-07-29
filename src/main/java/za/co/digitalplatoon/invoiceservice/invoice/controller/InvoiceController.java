package za.co.digitalplatoon.invoiceservice.invoice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import za.co.digitalplatoon.invoiceservice.invoice.model.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.service.InvoiceService;
import za.co.digitalplatoon.invoiceservice.invoice.service.LineItemService;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private LineItemService lineItemService;

    @RequestMapping(method = RequestMethod.POST, value = "/invoices")
    @ResponseBody
    public ResponseEntity<Invoice> addInvoice(Invoice invoice) {

	try {
	    invoiceService.create(invoice);
	    return new ResponseEntity(invoice, HttpStatus.OK);
	} catch (Exception e) {
	    System.out.println("Could not complete addInvoice: "
		    + e.getMessage());
	    return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @RequestMapping(method = RequestMethod.GET, value = "/invoices")
    @ResponseBody
    public ResponseEntity<Invoice> viewAllInvoices() {

	List<Invoice> items = new ArrayList();
	try {
	    List<Invoice> results = invoiceService.getAllInvoices();
	    items.addAll(results);

	    return new ResponseEntity(items, HttpStatus.OK);
	} catch (Exception e) {
	    System.out.println("Could not complete viewAllInvoices: "
		    + e.getMessage());
	    return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @RequestMapping(method = RequestMethod.GET, value = "/invoices/{invoiceId}")
    @ResponseBody
    public ResponseEntity viewInvoice(@PathVariable int invoiceId) {
	try {
	    Invoice invoice = invoiceService.getById(invoiceId);
	    return new ResponseEntity(invoice, HttpStatus.OK);
	} catch (Exception e) {
	    System.out.println("Could not complete viewInvoice: "
		    + e.getMessage());
	    return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }
}
