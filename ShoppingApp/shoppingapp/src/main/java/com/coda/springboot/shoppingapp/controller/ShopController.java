package com.coda.springboot.shoppingapp.controller;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coda.springboot.shoppingapp.service.ShopService;
import com.coda.springboot.shoppingapp.utils.InvoiceGenerator;
import com.coda.springboot.shoppingapp.utils.InvoiceItem;

@Controller
public class ShopController {
	
}
