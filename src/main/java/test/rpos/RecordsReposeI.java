package test.rpos;

import org.springframework.transaction.annotation.Transactional;
import test.ent.Records;

import java.util.List;

/**
 * @author Vorobyev Vyacheslav
 */
public interface RecordsReposeI {
    void save(List<Records> records);

    @Transactional
    void batchOnConflict(List<Records> list);

    void select();
}
