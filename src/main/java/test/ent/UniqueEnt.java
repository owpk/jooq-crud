package test.ent;

import lombok.*;

/**
 * @author Vorobyev Vyacheslav
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UniqueEnt {
    private Long id;
    private String name;
    private String val;
}