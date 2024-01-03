package com.example.SpringDemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;
@Document(collection = "movies")
@Data //to generate all the getter setters and toString methods
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDocument {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> generesList;
    private List<String> backDropsList;
    @DocumentReference //stores only the ids
    private List<ReviewsDocument> reviewIdsList;

}
