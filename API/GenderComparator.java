package API;

import java.util.Comparator;

public class GenderComparator implements Comparator<Personaje>{

	@Override
	public int compare(Personaje o1, Personaje o2) {
		return o1.getGender().compareTo(o2.getGender());
		//return o1.getGender().compareToIgnoreCase(o2.getStatus());
	}

}
