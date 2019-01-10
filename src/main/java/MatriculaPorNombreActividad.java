import java.util.Comparator;

public class MatriculaPorNombreActividad implements Comparator<Matricula> {
	public int compare (Matricula a, Matricula b){
		return a.getActividad().getNombre().compareTo(b.getActividad().getNombre());
	}
}
