import java.util.Comparator;
public class MatriculaPorCurso implements Comparator<Matricula> {
	public int compare(Matricula a, Matricula b) {
		return a.getCurso().compareTo(b.getCurso());
	}
}
