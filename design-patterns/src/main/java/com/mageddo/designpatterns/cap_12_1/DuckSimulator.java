package com.mageddo.designpatterns.cap_12_1;

public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}

	private void simulate() {
		// adiicionando um contador de quacks para os patos com o Padr�o Decorator
		Quackable mallarDuck = new QuackCounter(new MallardDuck());
		Quackable redHeadDuck = new QuackCounter(new RedheadDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		
		System.err.println("\\Duck Simulator");
		
		
		simulate(mallarDuck);
		simulate(redHeadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		
		System.out.println("\nLa vem um pato falso -->");
		
		// fazendo um ganso virar um pato pelo Padrao Adapter
		Quackable gansoQueVirouPato = new GooseAdapter(new Goose());
		simulate(gansoQueVirouPato);
		
		
		// resultado do Padrao Adapter
		System.out.printf("Ao todo %d patos fizeram Quack", QuackCounter.getQuacks());
		
	}
	
	private void simulate(Quackable duck) {
		duck.quack();

	}
}
