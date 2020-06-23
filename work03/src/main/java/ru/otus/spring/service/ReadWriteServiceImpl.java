package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class ReadWriteServiceImpl implements ReadWriteService {

    private final PrintStream printStream;
    private final Scanner scanner;

    public ReadWriteServiceImpl(@Value("#{ T(java.lang.System).in}") InputStream inputStream, @Value("#{ T(java.lang.System).out}") PrintStream printStream) {
        this.printStream = printStream;
        this.scanner = new Scanner(inputStream);
    }

    @Override
    public void write(String s) {
        printStream.print(s);
    }

    @Override
    public void writeln(String s) {
        printStream.println(s);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }

    @Override
    public String read(String s) {
        return read();
    }
}
