import java.util.ArrayList;
import java.util.HashMap;

public class Turma {

    private Disciplina disciplina;

    private Professor professor;

    private HashMap<Long, Aluno> alunosByDRE;

    private HashMap<Aluno, Float> notasByAluno;

    public Turma(Disciplina disciplina, Professor professor) {

        this.disciplina = disciplina;

        this.professor = professor;

        this.alunosByDRE = new HashMap<>();

        this.notasByAluno = new HashMap<>();

    }

    public void inscreverAluno(Aluno aluno) {

        this.alunosByDRE.put(aluno.getDre(), aluno);

    }

    public void atribuirMediaFinal(long dre, float nota) {

        Aluno aluno = this.alunosByDRE.get(dre);

        this.notasByAluno.put(aluno, nota);

    }

    public float obterMediaFinal(long dre) {

        Aluno aluno = this.alunosByDRE.get(dre);

        return this.notasByAluno.get(aluno);

    }

    public String listarAlunos() {

        String string = "Lista de alunos:\n";

        for(HashMap.Entry<Long, Aluno> item : alunosByDRE.entrySet()) {
            string += item.getValue().getNome() + " || DRE - " + item.getKey().toString() + "\n";
        }

        return string;

    }

}
