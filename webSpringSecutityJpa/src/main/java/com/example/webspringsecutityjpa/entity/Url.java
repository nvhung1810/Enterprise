package com.example.webspringsecutityjpa.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "url")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "loc", nullable = false)
    private String loc;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="url_new_id")
    private News thisnew;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="url_image_id")
    private Image thisimage;
}