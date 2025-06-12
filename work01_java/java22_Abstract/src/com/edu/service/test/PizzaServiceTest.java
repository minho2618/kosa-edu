package com.edu.service.test;

import java.util.ArrayList;
import java.util.List;

import com.edu.child.BulgogiPizza;
import com.edu.child.CombinationPizza;
import com.edu.child.PotatoPizza;
import com.edu.parent.Pizza;
import com.edu.service.PizzaService;

public class PizzaServiceTest {

	public static void main(String[] args) {
		List<Pizza> list = new ArrayList<Pizza>();
		list.add(new PotatoPizza(16000, "Mr.Pizza"));
		list.add(new BulgogiPizza(22000, "도미노"));
		list.add(new CombinationPizza(10000, "피자스쿨"));

		PizzaService service = new PizzaService();
		service.allMakePizza(list);
	}

}
