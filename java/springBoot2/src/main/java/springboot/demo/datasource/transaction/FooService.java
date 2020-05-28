package springboot.demo.datasource.transaction;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.RollbackException;

/**
 * @author taobaibai
 * @create 2020-05-27 23:29
 */
public interface FooService {
    @Transactional
    void insertRecord();

    @Transactional(rollbackFor = RollbackException.class)
    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;
}
