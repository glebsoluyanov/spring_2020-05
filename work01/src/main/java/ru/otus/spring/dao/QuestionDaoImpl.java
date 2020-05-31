package ru.otus.spring.dao;

import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.domain.Question;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {

    private final String path;

    public List<Question> getQuestions() throws IOException {
        InputStream is = this.getClass().getResourceAsStream(path);
        List<Question> questionList = new ArrayList<>();

        try(
                InputStreamReader reader = new InputStreamReader(is);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withDelimiter(';'));
        ){
            List<CSVRecord> recordList = csvParser.getRecords();
            for(CSVRecord record : recordList){
                Question question = new Question();
                question.setQuestion(record.get(0));
                question.setAnswer(record.get(1));
                questionList.add(question);
            }
        }

        return questionList;
    }
}
