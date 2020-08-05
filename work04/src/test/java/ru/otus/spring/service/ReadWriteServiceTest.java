package ru.otus.spring.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
class ReadWriteServiceTest {

    private static final String TEST_WRITE_TEXT = "Sample write text";
    private static final String TEST_READ_TEXT = "Sample read text";

    private ByteArrayOutputStream byteArrayOutputStream;
    private ByteArrayInputStream byteArrayInputStream;
    private ReadWriteService readWriteService;

    @BeforeEach
    void init() {
        System.out.println("init before test");
        byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayInputStream = new ByteArrayInputStream(TEST_READ_TEXT.getBytes());
        readWriteService = new ReadWriteServiceImpl(byteArrayInputStream, new PrintStream(byteArrayOutputStream));
    }

    @DisplayName("write \"" + TEST_WRITE_TEXT + "\"")
    @Test
    void write() {
        readWriteService.write(TEST_WRITE_TEXT);
        assertThat(byteArrayOutputStream.toString()).isEqualTo(TEST_WRITE_TEXT);
    }

    @DisplayName("writeln \"" + TEST_WRITE_TEXT + "\"")
    @Test
    void writeln() {
        readWriteService.writeln(TEST_WRITE_TEXT);
        assertThat(byteArrayOutputStream.toString()).isEqualTo(TEST_WRITE_TEXT+System.getProperty("line.separator"));
    }

    @DisplayName("read \"" + TEST_READ_TEXT + "\"")
    @Test
    void read() {
        assertThat(readWriteService.read()).isEqualTo(TEST_READ_TEXT);
    }
}