# Інструкція з використання програми

### Опис програми StringProcessor

Програма **StringProcessor** призначена для обробки текстових рядків шляхом видалення найдовшого підрядка між заданими символами у кожному реченні тексту.

#### Основні функції програми:
1. **Зчитування вхідного тексту**
   - Вхідний текст містить кілька речень, які розділені символами завершення речень (крапка, знак питання або знак оклику).

2. **Параметри пошуку**
   - Задані символи `startChar` і `endChar` визначають початок і кінець підрядка для обробки.

3. **Обробка тексту**
   - Програма обробляє текст речення за реченням, видаляючи найдовший підрядок між заданими символами для кожного речення.

4. **Виведення результатів**
   - Виводиться початковий текст і результат після обробки.


### Опис класів і методів

**1. Основний клас:**  
`StringProcessor`  
Виконує обробку вхідного тексту через метод `main`.

**2. Метод `main(String[] args):`**
- Приймає вхідні аргументи командного рядка (не використовується).
- Ініціалізує вхідний текст і символи для пошуку.
- Викликає метод `processText` для обробки тексту.
- Виводить результати або повідомлення про помилки.

**3. Метод `processText(StringBuilder text, char startChar, char endChar):`**
- Перевіряє валідність тексту (не може бути пустим або null).
- Розбиває текст на речення.
- Викликає метод `processSentence` для кожного речення.
- Повертає оброблений текст.

**4. Метод `processSentence(StringBuilder sentence, char startChar, char endChar):`**
- Шукає найдовший підрядок між символами `startChar` і `endChar` у реченні.
- Видаляє знайдений підрядок, якщо він існує.

**5. Метод `findSentenceEnd(StringBuilder text, int start):`**
- Знаходить кінець поточного речення (позицію першого символу ".", "!" або "?").
- Повертає індекс кінця речення або -1, якщо речення не знайдено.


### Обробка помилок
- **IllegalArgumentException** - виникає, якщо вхідний текст порожній або дорівнює null.
- **Exception** - обробляє всі інші непередбачені помилки.


 **Запуск програми:**

   - Використайте термінал:
     ```bash
     javac StringProcessor.java
     java StringProcessor
     ```

## Результат виконання
Програма виведе:
- Початковий текст
- Параметри пошуку підрядків
- Оброблений текст з видаленими підрядками

**Автор Демич Сергій**
