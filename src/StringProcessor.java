public class StringProcessor {
    /**
     * Виконавчий метод для обробки текстового рядка.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            // Вхідний текст з декількома реченнями
            String inputText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
                    + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";
            
            // Задані літери для пошуку підрядка
            char startChar = 'p';
            char endChar = 'i';

            System.out.println("Початковий текст: " + inputText);
            System.out.println("Шукаємо пiдрядки вiд '" + startChar + "' до '" + endChar + "'");

            // Конвертуємо String в StringBuilder для обробки
            StringBuilder textBuilder = new StringBuilder(inputText);
            
            // Обробляємо текст
            StringBuilder result = processText(textBuilder, startChar, endChar);
            
            // Конвертуємо результат назад у String для виведення
            System.out.println("\nРезультат: " + result.toString());

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка у вхідних даних: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Виникла непередбачена помилка: " + e.getMessage());
        }
    }

    /**
     * Обробляє текст, видаляючи найдовший підрядок між заданими символами в кожному реченні.
     *
     * @param text текст для обробки
     * @param startChar початковий символ підрядка
     * @param endChar кінцевий символ підрядка
     * @return оброблений текст
     * @throws IllegalArgumentException якщо текст пустий або null
     */
    private static StringBuilder processText(StringBuilder text, char startChar, char endChar) {
        if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Текст не може бути пустим");
        }

        // Розбиваємо текст на речення
        StringBuilder result = new StringBuilder();
        int start = 0;
        int end;
        
        while (start < text.length()) {
            // Знаходимо кінець поточного речення
            end = findSentenceEnd(text, start);
            if (end == -1) {
                end = text.length();
            }

            // Обробляємо окреме речення
            StringBuilder sentence = new StringBuilder(text.substring(start, end));
            processSentence(sentence, startChar, endChar);
            
            // Додаємо оброблене речення до результату
            result.append(sentence);
            
            // Переходимо до наступного речення
            start = end;
        }

        return result;
    }

    /**
     * Обробляє окреме речення, видаляючи найдовший підрядок між заданими символами.
     *
     * @param sentence речення для обробки
     * @param startChar початковий символ підрядка
     * @param endChar кінцевий символ підрядка
     */
    private static void processSentence(StringBuilder sentence, char startChar, char endChar) {
        int maxLength = -1;
        int startIndex = -1;
        int endIndex = -1;

        // Шукаємо найдовший підрядок
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.toLowerCase(sentence.charAt(i)) == Character.toLowerCase(startChar)) {
                for (int j = i + 1; j < sentence.length(); j++) {
                    if (Character.toLowerCase(sentence.charAt(j)) == Character.toLowerCase(endChar)) {
                        int length = j - i + 1;
                        if (length > maxLength) {
                            maxLength = length;
                            startIndex = i;
                            endIndex = j + 1;
                        }
                    }
                }
            }
        }

        // Видаляємо знайдений підрядок
        if (startIndex != -1) {
            sentence.delete(startIndex, endIndex);
        }
    }

    /**
     * Знаходить кінець речення.
     *
     * @param text текст для пошуку
     * @param start початкова позиція пошуку
     * @return індекс кінця речення або -1, якщо не знайдено
     */
    private static int findSentenceEnd(StringBuilder text, int start) {
        for (int i = start; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '.' || c == '!' || c == '?') {
                return i + 1;
            }
        }
        return -1;
    }
}