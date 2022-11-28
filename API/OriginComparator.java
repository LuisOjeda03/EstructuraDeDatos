package API;

import java.util.Comparator;

public class OriginComparator implements Comparator<Personaje>{

	@Override
	public int compare(Personaje o1, Personaje o2) {
		return o1.getOrigin().getName().compareTo(o2.getOrigin().getName());
	}

}
