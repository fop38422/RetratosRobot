package fp.dam.retratosrobot;

import java.util.ArrayList;
import java.util.List;

public class RetratoRobot {

//	private static final String [][] RASGOS = {
//			{"WWWWWWWWW", "\\\\\\//////", "|\"\"\"\"\"\"\"|", "|||||||||"},
//			{"|  O O  |", "|-(· ·)-|", "|-(o o)-|", "|  \\ /  |"},
//			{"@   J   @", "{   \"   }", "[   j   ]", "<   -   >"},
//			{"|  ===  |", "|   -   |", "|  ___  |", "|  ---  |"},
//			{" \\_____/ ", " \\,,,,,/ "}
//	};
	
	private static final List<List<String>> RASGOS = new ArrayList<>();
	static {
			RASGOS.add(new ArrayList<>(List.of("WWWWWWWWW", "\\\\\\//////", "|\"\"\"\"\"\"\"|", "|||||||||")));
			RASGOS.add(new ArrayList<>(List.of("|  O O  |", "|-(· ·)-|", "|-(o o)-|", "|  \\ /  |")));
			RASGOS.add(new ArrayList<>(List.of("@   J   @", "{   \"   }", "[   j   ]", "<   -   >")));
			RASGOS.add(new ArrayList<>(List.of("|  ===  |", "|   -   |", "|  ___  |", "|  ---  |")));
			RASGOS.add(new ArrayList<>(List.of(" \\_____/ ", " \\,,,,,/ ")));
	};
	
	private int [] rasgos = new int[5];
	
	public RetratoRobot() {
		for (int i=0; i<rasgos.length; i++)
			rasgos[i] = (int) (Math.random() * 10000) % RASGOS.get(i).size();
	}
	
	public RetratoRobot(int pelo, int ojos, int nariz, int boca, int barbilla) {
		setRasgo(Rasgos.PELO, pelo);
		setRasgo(Rasgos.OJOS, ojos);
		setRasgo(Rasgos.NARIZ, nariz);
		setRasgo(Rasgos.BOCA, boca);
		setRasgo(Rasgos.BARBILLA, barbilla);
	}
	
	public int getMaxRasgo(Rasgos rasgo) {
		return RASGOS.get(rasgo.ordinal()).size() - 1;
	}
	
	public int getRasgo(Rasgos rasgo) {
		return rasgos[rasgo.ordinal()];
	}
	
	public String getRasgoString(Rasgos rasgo) {
		return RASGOS.get(rasgo.ordinal()).get(rasgos[rasgo.ordinal()]);
	}
	
	public void setRasgo(Rasgos rasgo, int valor) {
		if (valor < 0 || valor >= RASGOS.get(rasgo.ordinal()).size())
			throw new IllegalArgumentException("opción para " + rasgo + "=" + valor + " inválida\n rango válido: 0 .. " + getMaxRasgo(rasgo));
		rasgos[rasgo.ordinal()] = valor;
	}
	
	@Override
	public String toString() {
//		return Stream.iterate(0, n -> n + 1)
//				.limit(rasgos.length)
//				.map(i -> RASGOS[i][rasgos[i]])
//				.collect(Collectors.joining("\n"));
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<rasgos.length; i++) {
			sb.append(RASGOS.get(i).get(rasgos[i]));
			if (i < rasgos.length - 1)
				sb.append("\n");
		}
		return sb.toString();
	}
	
}
