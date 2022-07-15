package test.ent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Vorobyev Vyacheslav
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Records {
    private Long id;
    private String name;
    private String data;
    private InnerRecord innerRecord;

    public Records(String name, String data) {
        this.name = name;
        this.data = data;
    }
}
