package cursojava.executavel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

public class PrimeiraClasseJava {



/* Main é um método auto executavel no java*/
public static void main(String[] args) {
	
String login = JOptionPane.showInputDialog("Informe o login");
String senha = JOptionPane.showInputDialog("Informe a senha");

if (login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")) {
	
		List<Aluno> alunos = new ArrayList<Aluno>();
		HashMap<String, List<Aluno>> maps= new HashMap<String, List<Aluno>>();
		
		
		
		for(int qtd=1;qtd<=5;qtd++) {
			
			String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd);
			
			//		int idade  = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do aluno?")) ;
			//		String dataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento do aluno?");
			//		String registroGeral = JOptionPane.showInputDialog("Qual o RG do aluno?");
			//		String numeroCpf = JOptionPane.showInputDialog("Qual o CPF do aluno?");
			//		String nomeMae=JOptionPane.showInputDialog("Qual o nome da mãe?");
			//		String nomePai=JOptionPane.showInputDialog("Qual o nome do pai?");
			//		String dataMatricula = JOptionPane.showInputDialog("Qual a data da matricula?");
			//		String serieMatriculado = JOptionPane.showInputDialog("Qual a serie matriculado?");
			//		String nomeEscola = JOptionPane.showInputDialog("Qual o nome da escola?");
			//		
			Aluno aluno1 = new Aluno();
			aluno1.setNome(nome);
			
			//		aluno1.setIdade(idade);
			//		aluno1.setDataNascimento(dataNascimento);
			//		aluno1.setRegistroGeral(registroGeral);
			//		aluno1.setNumeroCpf(numeroCpf);
			//		aluno1.setNomeMae(nomeMae);
			//		aluno1.setNomePai(nomePai);
			//		aluno1.setDataMatricula(dataMatricula);
			//		aluno1.setSerieMatriculado(serieMatriculado);
			//		aluno1.setNomeEscola(nomeEscola);
			//		
			for(int pos=1;pos<=1;pos++) {
				
				String nomeDisciplina = JOptionPane.showInputDialog("Insira o nome da disciplina - " + pos);
				double notaDisciplina = Double.parseDouble(JOptionPane.showInputDialog("insira a nota da disciplina - " +pos));
				
				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(notaDisciplina);
				
				aluno1.getDisciplinas().add(disciplina);
			}
			
			
			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");
			if (escolha==0) {//opção sim é zero
				int continuarRemover = 0;
				int posicao =1;
				while (continuarRemover ==0) {
					String disciplinaRemover = JOptionPane.showInputDialog("Qual disciplina 1,2,3 ou 4?");
					
					aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue()-posicao);
					posicao++;
					continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover?");
				}
			}
			
			alunos.add(aluno1);	
		}
		
		maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
		maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
		maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
		
		for(Aluno aluno: alunos) {
			if(aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				maps.get(StatusAluno.APROVADO).add(aluno);
			}else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				maps.get(StatusAluno.RECUPERACAO).add(aluno);
			}else{
				maps.get(StatusAluno.REPROVADO).add(aluno);
			}
		}
		
		System.out.println("------------------ lista dos aprovados ---------- ");
		for(Aluno aluno :maps.get(StatusAluno.APROVADO)) {
			System.out.println("Nome = "+ aluno.getNome() +" Resultado =" + aluno.getAlunoAprovado2() + " com média de = "+aluno.getMediaNota());
		}
		
		System.out.println("------------------ lista dos reprovados ---------- ");
		for(Aluno aluno :maps.get(StatusAluno.REPROVADO)) {
			System.out.println("Nome = "+ aluno.getNome() +" Resultado =" + aluno.getAlunoAprovado2() + " com média de = "+aluno.getMediaNota());
		}
		System.out.println("------------------ lista dos em recuperação ---------- ");
		for(Aluno aluno :maps.get(StatusAluno.RECUPERACAO)) {
			System.out.println("Nome = "+ aluno.getNome() +" Resultado =" + aluno.getAlunoAprovado2() + " com média de = "+aluno.getMediaNota());
		}
	}else {
		System.out.println("login e/ou senha inválidos");
		}
	}
}
