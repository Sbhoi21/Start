package basic;

import java.util.ArrayList;
import java.util.List;

public class InterfaceTest {

	public static void main(String[] args) {

		List<Developer> l = new ArrayList<Developer>();
		l.add(new BackendDeveloper());
		l.add(new BackendDeveloper());
		l.add(new FrontendDeveloper());
		l.add(new BackendDeveloper());
		l.add(new FrontendDeveloper());

		Project p = new Project(l);
		
		p.build();
		
		
		BackendDeveloper b = new abc();
		b.writeCode();
		
	}

}

interface Developer {
	void writeCode();
}

class BackendDeveloper implements Developer {
	public void writeCode() {
		/* Backend logic */
		System.out.println("backEnd");
	}
}

class FrontendDeveloper implements Developer {
	public void writeCode() {
		/* Frontend logic */
		System.out.println("FrontEnd");
	}
}

class abc extends BackendDeveloper{
	public void dance() {
		System.out.println("Dance");
	}
}

class Project {
	private List<Developer> developers;

	public Project(List<Developer> developers) {
		this.developers = developers;
	}

	public void build() {
		for (Developer dev : developers) {
			dev.writeCode();
		}
	}
}