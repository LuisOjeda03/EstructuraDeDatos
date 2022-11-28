package API;

import java.util.Comparator;

public class SpecieComparator implements Comparator<Personaje>{

	@Override
	public int compare(Personaje o1, Personaje o2) {
		//return o1.getEpisode().get(0).compareTo(o2.getEpisode().get(0));
		return o1.getSpecies().compareTo(o2.getSpecies());
	}
}