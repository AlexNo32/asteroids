package au.edu.griffithuni.asteroids.component;

public class ComponentFactory {
	
	public static IComponentBehavior generator(String component) {
		
		switch(component) {
		case "Frame" : 
			return new AsterFrame();
		
		case "Panel" : 
			return new AsterPanel();
		
		default:
			return null;
		}
		
		
	}

}
