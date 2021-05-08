package uz.kucharov.apibank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private Double salary;

    @Column(nullable = false)
    private Double creditAmount;

    @Column(nullable = false)
    private Double tolovMuddati;

    @Column(nullable = false)
    private Double kreditYillikFoizi;

    @Column
    private String result;

}
