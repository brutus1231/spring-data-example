package pl.sda.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEPARTAMENT")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentEntity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy="department")
    List<PersonEntity> persons;
}
