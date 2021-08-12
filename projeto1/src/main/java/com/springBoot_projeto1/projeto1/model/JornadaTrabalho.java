package com.springBoot_projeto1.projeto1.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class JornadaTrabalho {

    @Id
    @GeneratedValue
    private Long   id;
    @Column
    private String  descricao;


}
