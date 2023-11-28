package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.model.enums.Gender;
@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  Long id;
    @Column(unique = true)
    private String name;
    @Column (name = "last_name")
    private String lastName;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
