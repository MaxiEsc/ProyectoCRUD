package util;

import java.util.Comparator;

import model.Promocion;


public class OrdenadorPromociones implements Comparator<Promocion> {

	@Override
	public int compare(Promocion arg0, Promocion arg1) {
		if(arg0.getPrecio() == arg1.getPrecio()) {
			return Integer.valueOf((int)arg0.getPrecio()).compareTo((int)arg1.getPrecio());
		}
		return Integer.valueOf(arg0.getPrecio()).compareTo(arg1.getPrecio());
	}

}
