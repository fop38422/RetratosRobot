package fp.dam.retratosrobot;

public class Main {

	public static void main(String[] args) {
		RetratoRobot rr1 = new RetratoRobot();
		System.out.println(rr1);
		RetratoRobot rr2 = new RetratoRobot(2, 2, 3, 3, 1);
		System.out.println(rr2);
		rr2.setRasgo(Rasgos.BARBILLA, 0);
		System.out.println(rr2);
	}

}
