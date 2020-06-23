package ru.job4j.collection;

public class SimpleQueue<T> {
    private  SimpleStack<T> in = new SimpleStack<>();
    private  final SimpleStack<T> out = new SimpleStack<>();

    public void push(T value) {
        in.push(value);
    }

   public T poll() {
       if (out.getLength() == 0) {
           while (in.getLength() != 0) {
               out.push(in.pop());
           }
       }
       return out.pop();
   }
}