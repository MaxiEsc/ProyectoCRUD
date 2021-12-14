package util;

import java.util.Comparator;

import model.Atraccion;


public class OrdenadorAtracciones implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion arg0, Atraccion arg1) {
		if (arg0.getValor() == arg1.getValor()) {
			return Integer.valueOf((int)arg0.getDuracion().intValue()).compareTo((int)arg1.getDuracion().intValue());
		}
		return Integer.valueOf(arg0.getValor()).compareTo(arg1.getValor());
	}
	
}
