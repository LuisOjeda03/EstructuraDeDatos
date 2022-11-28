package API;

import java.util.Comparator;

public class NameComparator implements Comparator<Personaje>{

	@Override
	public int compare(Personaje o1, Personaje o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
