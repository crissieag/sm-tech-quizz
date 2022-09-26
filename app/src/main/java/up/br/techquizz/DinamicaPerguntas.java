package up.br.techquizz;

public class DinamicaPerguntas {
    public static String perguntas[] = {
            "Em qual data foi lançado o primeiro website?",
            "Qual o comando git para mudar de branch?",
            "Qual dessas linguagens é fracamente tipada?",
            "Como centralizar horizontalmente uma div container?"
    };

    public static String escolhas[][] = {
            {"27 de fevereiro de 1989", "14 de abril de 1995", "06 de agosto de 1991", "22 de novembro de 1992"},
            {"git branch --checkout <nome-da-branch>", "git checkout -b <nome-da-branch>", "git checkout <nome-da-branch>", "git branch <nome-da-branch>"},
            {"Ruby", "C++", "Scala", "Dart"},
            {".container {max-width: 1200px; margin: 0 auto}", ".container {max-width: 1200px; center: 0 auto}", ".container {max-width: 1200px; padding: 0 auto}", ".container {max-width: 1200px; center-h: auto}"}
    };

    public static String corretas[] = {
            "06 de agosto de 1991",
            "git checkout <nome-da-branch>",
            "Ruby",
            ".container {max-width: 1200px; margin: 0 auto}"
    };
}
