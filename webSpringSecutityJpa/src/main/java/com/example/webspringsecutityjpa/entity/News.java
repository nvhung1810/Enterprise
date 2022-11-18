package com.example.webspringsecutityjpa.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "publication_date", nullable = false)
    private String publication_date;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "date", nullable = false)
    private String date;

    @OneToOne(mappedBy = "thisnew")
    private Url thisurl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="new_publication_id")
    private Publication thispub;
}