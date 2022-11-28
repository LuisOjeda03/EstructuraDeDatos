package API;

import java.util.Comparator;

public class IdComparator implements Comparator<Personaje>{

	@Override
	public int compare(Personaje o1, Personaje o2) {
		// TODO Auto-generated method stub
		return o1.getID() < o2.getID() ? -1 : o1.getID() > o2.getID() ? 1 : 0;
	}	
}