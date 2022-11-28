package API;

import java.util.Comparator;

public class EstatusComparator implements Comparator<Personaje>{

	@Override
	public int compare(Personaje o1, Personaje o2) {
		return o1.getStatus().compareTo(o2.getStatus());
	}

}