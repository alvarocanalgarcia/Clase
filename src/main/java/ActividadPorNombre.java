import java.util.Comparator;
public class ActividadPorNombre implements Comparator<Actividad> {
	public int compare(Actividad a, Actividad b) {
		return a.getNombre().compareTo(b.getNombre());
	}
}
