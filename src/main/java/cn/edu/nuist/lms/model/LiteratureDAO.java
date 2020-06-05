package cn.edu.nuist.lms.model;

import java.util.List;
import java.sql.Date;

public interface LiteratureDAO {
    Literature selectById(long id);

    List<Literature> selectByTitle(String title);

    List<Literature> selectByAuthor(String author);

    List<Literature> selectByPublishTime(Date publishTime);

    void deleteById(long id);

    void update(Literature literature);

    void insert(Literature literature);

    List<Literature> loadFromFile(String filePath);

    void saveToFile(String filePath);
}
