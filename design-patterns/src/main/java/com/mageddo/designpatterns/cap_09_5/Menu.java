package com.mageddo.designpatterns.cap_09_5;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
	
	ArrayList menuComponents = new ArrayList();
	String name, description;
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
		
	}
	
	@Override
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}
	
	@Override
	public void remove(MenuComponent menuComponent){
		menuComponents.remove(menuComponent);
	}
	
	@Override
	public MenuComponent getChild(int i) {
		return (MenuComponent) menuComponents.get(i);
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public Iterator createIterator() {
		return new CompositeIterator(menuComponents.iterator());
	}
	
	@Override
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(",   " + getDescription());
		System.out.println("-------------------------");
		
		// Imprmindo os itens deste menu que podem ser itens realmente (folhas )
		// ou outros menus (n�s ) (recursividade aqui ;) )
		
		Iterator iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			((MenuComponent) iterator.next()).print();
		}
		

	}
	

    
    
    
}
