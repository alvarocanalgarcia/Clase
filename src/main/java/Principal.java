public class Principal {
	public static void main(String [] args) {
		Estudiante Est1=new Estudiante("Es1",true);
		Estudiante Est2=new Estudiante("Es2",false);
		Estudiante Est3=new Estudiante("Es3",true);
		Estudiante Est4=new Estudiante("Es4",false);
		Estudiante Est5=new Estudiante("Es5",true);
		Estudiante Est6=new Estudiante("Es6",false);
		Estudiante Est7=new Estudiante("Es7",true);
		Estudiante Est8=new Estudiante("Es8",false);
		Estudiante Est9=new Estudiante("Es9",true);
		Estudiante Est10=new Estudiante("Es10",false);
		
		Actividad Act1=new Reconocimiento("Prog1",60,"Programacion1");
		Actividad Act2=new Reconocimiento("Prog2",60,"Programacion2");
		Actividad Act3=new Reconocimiento("Prog3",60,"Programacion3");
		Actividad Act4=new Reconocimiento("Prog4",60,"Programacion4");
		Actividad Act5=new Reconocimiento("Prog5",60,"Programacion5");
		Actividad Act6=new Reconocimiento("Prog6",60,"Programacion6");
		Actividad Act7=new Reconocimiento("Prog7",60,"Programacion7");
		Actividad Act8=new Reconocimiento("Prog8",60,"Programacion8");
		Actividad Act9=new Reconocimiento("Prog9",60,"Programacion9");
		Actividad Act10=new Reconocimiento("Prog10",60,"Programacion10");
		
		Matricula Mat1=new Matricula(Act1,Est1,Curso.C1819,OrdenMatricula.M1,1);
		Matricula Mat2=new Matricula(Act2,Est2,Curso.C1718,OrdenMatricula.M1,2);
		Matricula Mat3=new Matricula(Act3,Est3,Curso.C1920,OrdenMatricula.M2,3);
		Matricula Mat4=new Matricula(Act4,Est4,Curso.C1718,OrdenMatricula.M2,4);
		Matricula Mat5=new Matricula(Act5,Est5,Curso.C1718,OrdenMatricula.M1,5);
		Matricula Mat6=new Matricula(Act6,Est6,Curso.C1617,OrdenMatricula.M4,6);
		Matricula Mat7=new Matricula(Act7,Est7,Curso.C1718,OrdenMatricula.M1,7);
		Matricula Mat8=new Matricula(Act8,Est8,Curso.C1718,OrdenMatricula.M3,8);
		Matricula Mat9=new Matricula(Act9,Est9,Curso.C1617,OrdenMatricula.M1,9);
		Matricula Mat10=new Matricula(Act10,Est10,Curso.C1718,OrdenMatricula.M1,10);
		
		Collection<Matricula> conjuntoporordenmatricula=new SortedSet<Matricula>(new MatriculaPorOrdenMatricula());
		
		Collection<Matricula> conjuntoporcurso=new SortedSet<Matricula>(new MatriculaPorCurso());
		
		Collection<Matricula> conjuntoporestudiante=new SortedSet<Matricula>(new MatriculaPorCuasiEstudiante());
		
		Collection<Matricula> conjuntoporactividad=new SortedSet<Matricula>(new MatriculaPorNombreActividad());
		
		conjuntoporordenmatricula.add(Mat1);
		conjuntoporordenmatricula.add(Mat2);
		conjuntoporordenmatricula.add(Mat3);
		conjuntoporordenmatricula.add(Mat4);
		conjuntoporordenmatricula.add(Mat5);
		conjuntoporordenmatricula.add(Mat6);
		conjuntoporordenmatricula.add(Mat7);
		conjuntoporordenmatricula.add(Mat8);
		conjuntoporordenmatricula.add(Mat9);
		conjuntoporordenmatricula.add(Mat10);

		conjuntoporcurso.add(Mat1);
		conjuntoporcurso.add(Mat2);
		conjuntoporcurso.add(Mat3);
		conjuntoporcurso.add(Mat4);
		conjuntoporcurso.add(Mat5);
		conjuntoporcurso.add(Mat6);
		conjuntoporcurso.add(Mat7);
		conjuntoporcurso.add(Mat8);
		conjuntoporcurso.add(Mat9);
		conjuntoporcurso.add(Mat10);
		
		conjuntoporestudiante.add(Mat1);
		conjuntoporestudiante.add(Mat2);
		conjuntoporestudiante.add(Mat3);
		conjuntoporestudiante.add(Mat4);
		conjuntoporestudiante.add(Mat5);
		conjuntoporestudiante.add(Mat6);
		conjuntoporestudiante.add(Mat7);
		conjuntoporestudiante.add(Mat8);
		conjuntoporestudiante.add(Mat9);
		conjuntoporestudiante.add(Mat10);
		
		conjuntoporactividad.add(Mat1);
		conjuntoporactividad.add(Mat2);
		conjuntoporactividad.add(Mat3);
		conjuntoporactividad.add(Mat4);
		conjuntoporactividad.add(Mat5);
		conjuntoporactividad.add(Mat6);
		conjuntoporactividad.add(Mat7);
		conjuntoporactividad.add(Mat8);
		conjuntoporactividad.add(Mat9);
		conjuntoporactividad.add(Mat10);
		
		System.out.println(conjuntoporordenmatricula.toString());
		
		System.out.println(conjuntoporcurso.toString());
		
		System.out.println(conjuntoporestudiante.toString());
		
		System.out.println(conjuntoporactividad.toString());
		
		System.out.println(conjuntoporordenmatricula.toArray());
		
		System.out.println(conjuntoporordenmatricula.remove(2));
		
		System.out.println(conjuntoporordenmatricula.toArray());
		

	}
}
