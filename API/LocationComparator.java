package API;

import java.util.Comparator;

public class LocationComparator implements Comparator<Personaje>{

	@Override
	public int compare(Personaje o1, Personaje o2) {
		return o1.getLocation().getName().compareTo(o2.getLocation().getName());
	}

}
