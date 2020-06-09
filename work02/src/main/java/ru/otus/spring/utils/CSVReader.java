package ru.otus.spring.utils;

import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import ru.otus.spring.domain.Question;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RequiredArgsConstructor
public final class CSVReader {

    public static List<Question> getQuestionsFromFile(String path){
        List<Question> questionList = new ArrayList<>();
        InputStream is = CSVReader.class.getResourceAsStream(path);
        try {
            InputStreamReader reader = new InputStreamReader(is);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withDelimiter(';'));
            List<CSVRecord> recordList = csvParser.getRecords();
            for (CSVRecord record : recordList) {
                Question question = new Question();
                question.setQuestion(record.get(0));
                question.setAnswer(record.get(1));
                questionList.add(question);
            }
            return questionList;
        }catch (IOException e){
            return questionList;
        }
    }
}
