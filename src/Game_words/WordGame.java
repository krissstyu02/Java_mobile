import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Класс WordGame реализует интерфейс Runnable и представляет игру со словами, выполняемую несколькими потоками.
class WordGame implements Runnable {
    private static final int TOTAL_THREADS = 5;
    private static final int WORDS_PER_THREAD = 4;

    // Общий замок для синхронизации потоков.
    private static final Lock lock = new ReentrantLock();

    // Массив списков слов для каждого потока.
    private static List<String>[] wordArrays = new List[TOTAL_THREADS];

    // Общий список для хранения всех слов.
    private static List<String> allWords = new ArrayList<>();

    // Идентификатор текущего активного потока.
    private static int currentPlayer = 1;

    // Флаг, сигнализирующий об окончании работы всех потоков.
    private static boolean allThreadsFinished = false;

    // Идентификатор текущего потока.
    private int threadId;

    // Конструктор принимает и устанавливает идентификатор текущего потока.
    public WordGame(int threadId) {
        this.threadId = threadId;
        // Инициализация списка слов для текущего потока.
        wordArrays[threadId - 1] = new ArrayList<>();
    }

    // Метод, который выполняется при запуске потока.
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Game_words/words.txt"))) {
            int wordCount = 0;
            // Бесконечный цикл чтения слов из файла.
            while (true) {
                synchronized (lock) {
                    // Пока не пришла очередь текущего потока или все потоки завершили работу, поток ожидает.
                    while (currentPlayer != threadId && !allThreadsFinished) {
                        lock.wait();
                    }

                    // Чтение слова из файла.
                    String word = reader.readLine();
                    if (word == null) {
                        // Если слова в файле закончились, устанавливаем флаг завершения работы всех потоков.
                        allThreadsFinished = true;
                    } else {
                        // Если слово прочитано, добавляем его в список текущего потока и выводим в консоль.
                        if (wordCount % TOTAL_THREADS == threadId - 1) {
                            wordArrays[threadId - 1].add(word);
                            System.out.println(threadId + ": " + word);
                        }
                        wordCount++;
                    }

                    // Переключение на следующий поток.
                    currentPlayer = (currentPlayer % TOTAL_THREADS) + 1;
                    // Уведомление всех потоков о возможности продолжить выполнение.
                    lock.notifyAll();

                    // Если все потоки завершили работу, выход из бесконечного цикла.
                    if (allThreadsFinished) {
                        break;
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Основной метод программы.
    public static void main(String[] args) throws InterruptedException {
        // Массив потоков для выполнения игры.
        Thread[] threads = new Thread[TOTAL_THREADS];

        // Создание и запуск каждого потока.
        for (int i = 0; i < TOTAL_THREADS; i++) {
            threads[i] = new Thread(new WordGame(i + 1));
            threads[i].start();
        }

        // Ожидание завершения работы всех потоков.
        for (int i = 0; i < TOTAL_THREADS; i++) {
            threads[i].join();
        }

        // Вывод слов для каждого потока.
        for (int i = 0; i < TOTAL_THREADS; i++) {
            System.out.println("Thread " + (i + 1) + " words: " + wordArrays[i]);
        }

        // Формирование списка всех слов в обратном порядке.
        for (int i = 0; i < WORDS_PER_THREAD; i++) {
            for (int j = 0; j < TOTAL_THREADS; j++) {
                if (wordArrays[j].size() > i) {
                    allWords.add(wordArrays[j].get(i));
                }
            }
        }

        // Вывод всех слов в обратном порядке.
        System.out.println("\nВывод слов в обратном порядке:");

        for (int i = allWords.size() - 1; i >= 0; i--) {
            System.out.println(allWords.get(i));
        }
    }
}
