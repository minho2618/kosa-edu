package com.edu.service;

import java.util.List;

import com.edu.parent.Pizza;

public class PizzaService {
	public void allMakePizza(List<Pizza> list) {
		for (Pizza p : list) {
			System.out.println(p);
			p.sequencePizza();
			System.out.println(" ----------- ");
		}
	}
}
