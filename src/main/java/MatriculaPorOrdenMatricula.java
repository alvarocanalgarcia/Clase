import java.util.Comparator;
public class MatriculaPorOrdenMatricula implements Comparator<Matricula> {
	public int compare(Matricula a, Matricula b) {
		return a.getOrdenMatricula().compareTo(b.getOrdenMatricula());
	}
}
