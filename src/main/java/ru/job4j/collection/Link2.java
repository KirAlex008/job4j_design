package ru.job4j.collection;

public class Link2 {

    public long dData;                 // Данные
    public Link2 next;                  // Следующий элемент в списке
    // -------------------------------------------------------------
    public Link2(long d)                // Конструктор
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink()          // Вывод содержимого элемента
    { System.out.print(dData + " "); }
// -------------------------------------------------------------
}  // Конец класса Link
