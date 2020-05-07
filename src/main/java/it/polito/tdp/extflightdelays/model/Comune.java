package it.polito.tdp.extflightdelays.model;

public class Comune {
	private Airport aPartenza;
	private Airport aArrivo;
	private double media;
	
	public Comune(Airport aPartenza, Airport aArrivo, double media) {
	
		this.aPartenza = aPartenza;
		this.aArrivo = aArrivo;
		this.media = media;
	}

	public Airport getaPartenza() {
		return aPartenza;
	}

	public void setaPartenza(Airport aPartenza) {
		this.aPartenza = aPartenza;
	}

	public Airport getaArrivo() {
		return aArrivo;
	}

	public void setaArrivo(Airport aArrivo) {
		this.aArrivo = aArrivo;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	

}
