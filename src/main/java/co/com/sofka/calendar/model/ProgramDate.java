package co.com.sofka.calendar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Objects;

@Document(collection = "planes")
public final class ProgramDate {
    @Id
    private final String categoryName;
    private final LocalDate date;

    public ProgramDate(String categoryName, LocalDate date) {
        this.categoryName = Objects.requireNonNull(categoryName);
        this.date = Objects.requireNonNull(date);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "ProgramDate{" +
                "categoryName='" + categoryName + '\'' +
                ", date=" + date +
                '}';
    }
}
