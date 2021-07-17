package pl.sda.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonEntity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String pesel;

    @ManyToOne
    @JoinColumn(name="department_id")
    private DepartmentEntity department;

    @Override
    public String toString() {
        return "PersonEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
}
