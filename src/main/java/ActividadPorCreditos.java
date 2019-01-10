import java.util.Comparator;
public class ActividadPorCreditos implements Comparator<Actividad>{
	public int compare (Actividad a, Actividad b) {
		return a.getCreditos()-b.getCreditos();
	}
}
