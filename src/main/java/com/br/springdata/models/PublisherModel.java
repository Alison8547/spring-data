package com.br.springdata.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_PUBLISHER")
public class PublisherModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // indicar dentro de um DTO quais atributos da classe são exclusivamente para leitura ou escrita do JSON.
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY) // FetchType.LAZY == carregamento lento, não é preciso carregar toda hora e sim só quando for solicitado
    private Set<BookModel> books = new HashSet<>(); // List pode dar vários problemas com muitos relacionamentos e o Set evita isso.


}
