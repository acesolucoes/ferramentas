package beans;

import java.util.ArrayList;
import java.util.List;


public class Clazz {
	private List<Attribute> attributes;

	public Clazz() {
		this.attributes = new ArrayList<Attribute>();
	}
	
	public List<Attribute> getAttributes() {
		return attributes;
	}
	
	public void addAttribute( Attribute attribute ){
		attributes.add(attribute);
	}
	
	public Attribute getAttribute( int position ){
		return attributes.get(position);
	}
}
