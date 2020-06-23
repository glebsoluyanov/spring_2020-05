package ru.otus.spring.service;

public interface ReadWriteService {
    void write(String s);
    void writeln(String s);
    String read(String s);
    String read();
}
