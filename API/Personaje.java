package API;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Mario Rios <jose.rf@culiacan.tecnm.mx>
 * Clase generada a partir de Json + https://app.quicktype.io/
 */
public class Personaje implements Comparable<Personaje>{
    private long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Location origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private Date created;
    
    Personaje(long id, String name){
    	this.id = id;
    	this.name = name;
    }

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getStatus() { return status; }
    public void setStatus(String value) { this.status = value; }

    public String getSpecies() { return species; }
    public void setSpecies(String value) { this.species = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public String getGender() { return gender; }
    public void setGender(String value) { this.gender = value; }

    public Location getOrigin() { return origin; }
    public void setOrigin(Location value) { this.origin = value; }

    public Location getLocation() { return location; }
    public void setLocation(Location value) { this.location = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public List<String> getEpisode() { return episode; }
    public void setEpisode(List<String> value) { this.episode = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public Date getCreated() { return created; }
    public void setCreated(Date value) { this.created = value; }
    
	@Override
	public int compareTo(Personaje o) {
		// Compara nombres
		
		return this.name.compareTo(o.name);
	}
	
	public int compare(Personaje o, int op)
	{
		return this.species.compareTo(o.species);
	}
}
