package it.polito.tdp.extflightdelays.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();

		model.creaGrafo(4500);
		System.out.println(model.nArchi());
		System.out.println(model.nVertici());
		
	}

}
