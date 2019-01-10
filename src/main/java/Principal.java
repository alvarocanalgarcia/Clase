

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
		
		Actividad Act1=new Actividad("act1",1);
		Actividad Act2=new Actividad("act2",2);
		Actividad Act3=new Actividad("act3",3);
		Actividad Act4=new Actividad("act4",4);
		Actividad Act5=new Actividad("act5",5);
		Actividad Act6=new Actividad("act6",6);
		Actividad Act7=new Actividad("act7",7);
		Actividad Act8=new Actividad("act8",8);
		Actividad Act9=new Actividad("act9",9);
		Actividad Act10=new Actividad("act10",10);
		
		Matricula Matr1=new Matricula(Act1,Est1,Curso.C1819,OrdenMatricula.M1,1);
		Matricula Matr2=new Matricula(Act2,Est2,Curso.C1718,OrdenMatricula.M1,2);
		Matricula Matr3=new Matricula(Act3,Est3,Curso.C1920,OrdenMatricula.M2,3);
		Matricula Matr4=new Matricula(Act4,Est4,Curso.C1718,OrdenMatricula.M2,4);
		Matricula Matr5=new Matricula(Act5,Est5,Curso.C1718,OrdenMatricula.M1,5);
		Matricula Matr6=new Matricula(Act6,Est6,Curso.C1617,OrdenMatricula.M4,6);
		Matricula Matr7=new Matricula(Act7,Est7,Curso.C1718,OrdenMatricula.M1,7);
		Matricula Matr8=new Matricula(Act8,Est8,Curso.C1718,OrdenMatricula.M3,8);
		Matricula Matr9=new Matricula(Act9,Est9,Curso.C1617,OrdenMatricula.M1,9);
		Matricula Matr10=new Matricula(Act10,Est10,Curso.C1718,OrdenMatricula.M1,10);
		
		Collection<Matricula> conjuntoporordenmatricula=new SortedSet<Matricula>(new MatriculaPorOrdenMatricula());
		
		Collection<Matricula> conjuntoporcurso=new SortedSet<Matricula>(new MatriculaPorCurso());
		
		Collection<Matricula> conjuntoporestudiante=new SortedSet<Matricula>(new MatriculaPorCuasiEstudiante());
		
		Collection<Matricula> conjuntoporactividad=new SortedSet<Matricula>(new MatriculaPorNombreActividad());
		
		conjuntoporordenmatricula.add(Matr1);
		conjuntoporordenmatricula.add(Matr2);
		conjuntoporordenmatricula.add(Matr3);
		conjuntoporordenmatricula.add(Matr4);
		conjuntoporordenmatricula.add(Matr5);
		conjuntoporordenmatricula.add(Matr6);
		conjuntoporordenmatricula.add(Matr7);
		conjuntoporordenmatricula.add(Matr8);
		conjuntoporordenmatricula.add(Matr9);
		conjuntoporordenmatricula.add(Matr10);

		conjuntoporcurso.add(Matr1);
		conjuntoporcurso.add(Matr2);
		conjuntoporcurso.add(Matr3);
		conjuntoporcurso.add(Matr4);
		conjuntoporcurso.add(Matr5);
		conjuntoporcurso.add(Matr6);
		conjuntoporcurso.add(Matr7);
		conjuntoporcurso.add(Matr8);
		conjuntoporcurso.add(Matr9);
		conjuntoporcurso.add(Matr10);
		
		conjuntoporestudiante.add(Matr1);
		conjuntoporestudiante.add(Matr2);
		conjuntoporestudiante.add(Matr3);
		conjuntoporestudiante.add(Matr4);
		conjuntoporestudiante.add(Matr5);
		conjuntoporestudiante.add(Matr6);
		conjuntoporestudiante.add(Matr7);
		conjuntoporestudiante.add(Matr8);
		conjuntoporestudiante.add(Matr9);
		conjuntoporestudiante.add(Matr10);
		
		conjuntoporactividad.add(Matr1);
		conjuntoporactividad.add(Matr2);
		conjuntoporactividad.add(Matr3);
		conjuntoporactividad.add(Matr4);
		conjuntoporactividad.add(Matr5);
		conjuntoporactividad.add(Matr6);
		conjuntoporactividad.add(Matr7);
		conjuntoporactividad.add(Matr8);
		conjuntoporactividad.add(Matr9);
		conjuntoporactividad.add(Matr10);
		
		System.out.println(conjuntoporordenmatricula.toString());
		
		System.out.println(conjuntoporcurso.toString());
		
		System.out.println(conjuntoporestudiante.toString());
		
		System.out.println(conjuntoporactividad.toString());
		
		System.out.println(conjuntoporordenmatricula.toArray());
		
		System.out.println(conjuntoporordenmatricula.remove(2));
		
		System.out.println(conjuntoporordenmatricula.toArray());
		

	}
}
