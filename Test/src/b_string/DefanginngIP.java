package b_string;

public class DefanginngIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String address = "1.1.1.1";
		System.out.println(defangIPaddr(address));
	}

	public static String defangIPaddr(String address) {
		return address.replace(".", "[.]");
	}

}
