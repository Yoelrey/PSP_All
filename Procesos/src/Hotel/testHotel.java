package Hotel;

public class testHotel {
public static void main(String[] args) {
	Hotel hotel= new Hotel(30);
	for (int i = 1; i<=50;i++) {
	Cliente c = new Cliente("Cliente numero "+i , hotel);	
		
	}
}
}
