package com.example.instagram.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer MediaId;

    private String name;
    @ManyToOne
    @JoinColumn(name ="postId" )
    private Post post;
    private String MediaURL;
    private String MediaType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] mediaData;
}
