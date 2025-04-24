package docker.lab3.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id", nullable=false)
    private Long id;

    @Column
    private String name;

    @Column
    private float price;

    @Column
    private int quantity;
}
