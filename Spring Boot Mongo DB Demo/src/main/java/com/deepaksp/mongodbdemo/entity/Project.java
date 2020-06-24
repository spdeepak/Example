package com.deepaksp.mongodbdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@Builder
@NoArgsConstructor
@AllArgsConstructor
@CompoundIndexes({@CompoundIndex(name = "project_details_key", def = "{'id' : 1, 'details.key' : 1}", unique = true)})
public class Project {
    @Field("id")
    private String id;
    private String name;
    @Field("details")
    private List<Details> details = new ArrayList<>();
}
