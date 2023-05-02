import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  /*-----------------Задача 1
/*Программисты, как вы уже знаете, постоянно учатся, а в общении между собой используют
/*весьма специфический язык. Чтобы систематизировать ваш пополняющийся профессиональный лексикон,
/*мы придумали эту задачу. Напишите программу создания небольшого словаря сленговых программерских
/* выражений, чтобы она потом по запросу возвращала значения из этого словаря.
/*-----------------Формат входных данных
/*Файл dict.txt
/*В первой строке задано одно целое число n — количество слов в словаре.
/*В следующих n строках записаны слова и их определения, разделенные двоеточием и символом пробела.
/*------------------Ввод с клавиатуры
/*В первой строке записано целое число m — количество поисковых слов, чье определение нужно вывести.
/*В следующих m строках записаны сами слова, по одному на строке.
/*------------------Формат выходных данных
/*Для каждого слова, независимо от регистра символов, если оно присутствует в словаре,
/*необходимо вывести на экран его определение.
/*Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.
/*------------------Примечание 1
/*Мини-словарь для начинающих разработчиков можно посмотреть тут.
/*------------------Примечание 2
/*Гарантируется, что в определяемом слове или фразе отсутствует двоеточие (:),
/*следом за которым идёт пробел.
/*------------------Пример входных данных
/*5
/*Змея: язык программирования Python
/*Баг: от англ. bug — жучок, клоп, ошибка в программе
/*Конфа: конференция
/*Костыль: Код, который нужен, чтобы исправить несовершенство ранее написанного кода
/*Бета: бета-версия, приложение на стадии публичного тестирования
/*3
/*Змея
/*Жаба
/*костыль
/*Пример выходных данных
/*язык программирования Python
/*Не найдено
/*код, который нужен, чтобы исправить несовершенство ранее написанного кода */

  private static final String SEP = ": ";

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    requestFromConsole(scanner);
  }

  public static Map<String, String> readInput(String filename) throws IOException {
    Map<String, String> dictionary = new HashMap<>();
    Scanner scanner = new Scanner(new FileReader(filename));
    int n = scanner.nextInt(); // Считали сканером число, количество строк
    scanner.nextLine();        // Перешли на следующую строку
    for (int i = 0; i < n; i++) {
      String dict = scanner.nextLine();
      int sepIndex = dict.indexOf(SEP);
      String wordToKey = dict.toLowerCase().substring(0, sepIndex);
      String contextToValue = dict.toLowerCase().substring(sepIndex + 1);
      dictionary.put(wordToKey, contextToValue);
    }
    return dictionary;
  }

  public static void requestFromConsole(Scanner scanner) throws IOException {
    System.out.print("Введите слово: ");
    String word1 = scanner.nextLine().toLowerCase();
    String value = readInput("res/dict.txt").get(word1);
    if (value == null) {
      System.out.println("Слово не найдено");
    } else {
      System.out.println("Значение слова : " + value);
    }
  }
}
