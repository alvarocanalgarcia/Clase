import java.util.Comparator;
public class EstudiantePorCuasi implements Comparator<Estudiante> {
	public int compare(Estudiante a, Estudiante b) {
		return a.getCuasi().compareTo(b.getCuasi());
	}
}
