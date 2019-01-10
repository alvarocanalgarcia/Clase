import java.util.Comparator;
public class MatriculaPorCuasiEstudiante implements Comparator<Matricula>{
	public int compare (Matricula a, Matricula b) {
		return a.getEstudiante().getCuasi().compareTo(b.getEstudiante().getCuasi());
	}
}
