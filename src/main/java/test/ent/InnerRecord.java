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
public class InnerRecord {
    private String name;
    private InnerInnerRecord innerInnerRecord;
}
