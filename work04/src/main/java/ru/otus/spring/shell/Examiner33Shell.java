package ru.otus.spring.shell;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.service.Examiner33Service;

@RequiredArgsConstructor
@ShellComponent
public class Examiner33Shell {
    private final Examiner33Service examiner33Service;

    @ShellMethod(value = "Start examine command", key = {"start", "st"})
    public void startExam(){
        examiner33Service.start();
    }
}
