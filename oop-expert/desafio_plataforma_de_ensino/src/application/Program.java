package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantas aulas tem o curso? ");
		int quantity = sc.nextInt();
		List<Lesson> lessons = new ArrayList<>();

		for (int i = 1; i <= quantity; i++) {
			System.out.println();
			System.out.println("Dados da " + i + "a aula:");
			System.out.print("Conteudo ou tarefa (c/t)? ");
			char lessonType = sc.next().toLowerCase().charAt(0);

			while (lessonType != 'c' && lessonType != 't') {
				System.out.print("Por favor, indique um tipo valido (c/t): ");
				lessonType = sc.next().toLowerCase().charAt(0);
			}

			if (lessonType == 'c') {
				Video video = new Video();
				System.out.print("Titulo: ");
				sc.nextLine();
				video.setTitle(sc.nextLine());
				System.out.print("URL do video: ");
				video.setUrl(sc.nextLine());
				System.out.print("Duracao em segundos: ");
				video.setSeconds(sc.nextInt());
				lessons.add(video);
			} else {
				Task task = new Task();
				System.out.print("Titulo: ");
				sc.nextLine();
				task.setTitle(sc.nextLine());
				System.out.print("Descricao: ");
				task.setDescription(sc.nextLine());
				System.out.print("Quantidade de questoes: ");
				task.setQuestionCount(sc.nextInt());
				lessons.add(task);
			}

		}
		
		int totalTime = 0;
		
		for (Lesson lesson : lessons) {
			totalTime += lesson.duration();
		}
		
		System.out.println("");
		System.out.printf("DURACAO TOTAL DO CURSO = %d segundos", totalTime);

		sc.close();
	}

}
