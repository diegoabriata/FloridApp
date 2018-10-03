package com.floridApp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.floridApp.model.Customer;
import com.floridApp.model.Sale;

import com.floridApp.service.BarrelService;
import com.floridApp.service.CustomerService;
import com.floridApp.service.SaleOrderService;
import com.floridApp.service.SaleService;



@Controller
@RequestMapping(value="/order")
public class OrderController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private BarrelService barrelService;
	
	@Autowired 
	private SaleOrderService saleOrderService;
	
	private final static String ORDER = "saleOrder/saleOrder_addOrUpdate";
	private final static String SALE_LIST = "sale/sale_list";
	
	
	//@manyToMany relationship with extra fields 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String barrelList(Model model){
		
		model.addAttribute("customers", customerService.getAllCustomer());
        model.addAttribute("barrels", barrelService.getAllBarrel());
        model.addAttribute("sales", saleService.getAllSale());
        model.addAttribute("orders", saleOrderService.getAllSaleOrder());
        return ORDER;
    }
	@RequestMapping(value= {"/createOrder"}, method = RequestMethod.POST)
    @ResponseBody //https://stackoverflow.com/questions/28646332/how-does-the-spring-responsebody-annotation-work-in-this-restful-application-ex
    public String saveOrder(@RequestParam String remito, @RequestParam String date, 
    		@RequestParam Double total, @RequestParam String description, 
    		@RequestParam Customer customer,@RequestParam(value="barrelIds[]") Long[] barrelIds,
    		@RequestParam(value="typesBeers[]") String[] typesBeers, @RequestParam (value="beerPrices[]") Double[] beerPrices, 
    		@RequestParam (value="barrelsLiters[]")Double barrelsLiters, 
    		@RequestParam (value="barrelStatus[]") boolean barrelStatus) throws ParseException{
		
		//1.Instantiate a new Sale object and save it
		Sale sale = new Sale();
		sale.setRemito(remito);
		sale.setDescription(description);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date d1 = format1.parse(date);
        sale.setDate(d1);
        sale.setCustomer(customer);
        sale.setTotal(total);
        saleService.saveOrUpdate(sale);
      		
        /*for(Long barrelId: barrelIds) {
        	
        	SaleOrder saleOrder = new SaleOrder();
        	saleOrder.setBarrel(barrelService.getBarrelById(barrelId));
        	saleOrder.setSale(sale);
        	saleOrder.setBarrelStatus(barrelStatus);
        	saleOrder.setTypeBeer(typeBeer);
    		saleOrder.setBeerPrice(beerPrice);
    		saleOrder.setBarrelLiters(barrelLiters);
        
		}*/
        
		return SALE_LIST;
	}
	
	
	
	
	
	
	//@manyToMany relationship without extra fields 
	/*@RequestMapping(value="/createorder", method = RequestMethod.POST)
    @ResponseBody
    public String saveOrder(@RequestParam String remito, @RequestParam String date, 
    		@RequestParam Double total, @RequestParam String description, 
    		@RequestParam Customer customer,@RequestParam(value="barrelIds[]") Long[] barrelIds,
    		@RequestParam String typeBeer) throws ParseException{
		
		System.out.println("remito:"+remito);
		System.out.println("date:"+date);
		System.out.println("total:"+total);
		System.out.println("description:"+description);
		System.out.println("barrelIds:"+barrelIds);
		
		System.out.println("customer:"+customer);
		
		Sale sale = new Sale();
		sale.setRemito(remito);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date d1 = format1.parse(date);
        sale.setDate(d1);
		sale.setTotal(total); //wrong need to be fixed
		sale.setDescription(description);
		sale.setCustomer(customer);
		saleService.saveOrUpdate(sale);
		// Ajax works so far...
		
		System.out.println("Barrels length:"+barrelIds.length);
		
		SaleOrder saleOrder = new SaleOrder();
		saleOrder.setSale(sale);
		//saleOrder.setSale(saleService.getSaleById(sale.getId()));
		//saleOrder.getSale().getCustomer();
		System.out.println("saleOrder.getSale:"+saleOrder.getSale());
		
		List<Barrel> barrelSet = new ArrayList<Barrel>();
		
		for(Long barrelId: barrelIds) {
			barrelSet.add(barrelService.getBarrelById(barrelId));
		}
		saleOrder.setBarrels(barrelSet);
		System.out.println("barrelSet:"+saleOrder.getBarrels().toString());
		
		saleOrder.setTypeBeer(typeBeer); //warning: not in the code!
		System.out.println("saleOrder.getTypeBeer:"+saleOrder.getTypeBeer());
		
		//@RequestParam Double total is NOT the same saleOrder total
		Double Total=0.0;
		for(Long barrelId: barrelIds) {
			//Total = Total + (barrelService.getBarrelById(barrelId).getBarrelPrice());
			System.out.println("Total:"+Total);
		}
		saleOrder.setTotal(Total);
		
		saleOrderService.saveOrUpdate(saleOrder);
		
		return saleOrder.getOrderId().toString();
	}
	@RequestMapping(value = "/removeorder", method = RequestMethod.POST)
    @ResponseBody
    public String removeOrder(@RequestParam Long Id){
        saleOrderService.deleteSaleOrder(Id);
        return Id.toString();
    }*/
	
	
	
}
