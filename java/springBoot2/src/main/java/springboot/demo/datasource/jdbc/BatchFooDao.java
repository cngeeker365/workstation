package springboot.demo.datasource.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taobaibai
 * @create 2020-05-27 22:58
 */
@Slf4j
@Repository
public class BatchFooDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void
    batchInsert() {
        jdbcTemplate.batchUpdate("INSERT INTO F00 (BAR) VALUES (?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, "b-" + i);
                    }

                    @Override
                    public int getBatchSize() {
                        return 2;
                    }
                });
        List<Foo> list = new ArrayList<>();
        list.add(Foo.builder().id(100L).bar("b- 100").build());
        list.add(Foo.builder().id(101L).bar("b-101").build());
        namedParameterJdbcTemplate.batchUpdate("INSERT INTO FOO (ID, BAR) VALUES (:id, :bar)",
                SqlParameterSourceUtils.createBatch(list));
    }

}
