package tecsup.edu.pe.democrudjdbc.controller;
import tecsup.edu.pe.democrudjdbc.model.Curso; import tecsup.edu.pe.democrudjdbc.service.CursoService;
import java.util.List;


public class CursoServiceTest  {
    public static void main(String[] args) {
        CursoService cursoService = new CursoService();

        try {
            List<Curso> cursos = cursoService.listarCursos();
            System.out.println("Número de cursos recuperados: " + cursos.size());

            if (cursos.isEmpty()) {
                System.out.println("⚠️ No se encontraron cursos en la base de datos.");
            } else {
                for (Curso curso : cursos) {
                    System.out.println("Código: " + curso.getCodigo());
                    System.out.println("Nombre: " + curso.getNombre());
                    System.out.println("Créditos: " + curso.getCreditos());
                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error al obtener cursos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
