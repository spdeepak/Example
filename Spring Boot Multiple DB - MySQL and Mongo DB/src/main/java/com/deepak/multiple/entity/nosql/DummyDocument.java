package com.deepak.multiple.entity.nosql;

import com.deepak.multiple.entity.Dummy;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class DummyDocument {

    @Id
    private String id;
    private Dummy dummy;

    public DummyDocument(Dummy dummy) {
        this.dummy = dummy;
    }

}
