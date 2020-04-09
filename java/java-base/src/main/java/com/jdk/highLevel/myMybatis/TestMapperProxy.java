package com.jdk.highLevel.myMybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author taobaibai
 * @create 2020-04-06 19:36
 */
interface SearchDao{ //SearchMapper
    Object search(String msg);
}

interface SqlSession{
    List<Object> selectList(String statement);
}
class DefaultSqlSession implements SqlSession{
    @Override
    public List<Object> selectList(String statement) {
        System.out.println("select list");
        return null;
    }
}

class MapperProxyHandler implements InvocationHandler {
    private SqlSession sqlSession;
    private Class<?> targetInterface;

    public MapperProxyHandler(SqlSession sqlSession, Class<?> targetInterface) {
        this.sqlSession = sqlSession;
        this.targetInterface = targetInterface;
    }

    /**
     * invoke 方法是为代理对象执行具体业务
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MapperProxyHandler.invoke");
        String clsName = targetInterface.getName();
        String methodName = method.getName();
        String statement = clsName+"."+methodName;
        return sqlSession.selectList(statement);
    }
}

class MapperProxyFactory{
    /**
     * 借助该属性封装要产生代理对象的目标接口
     */
    private Class<?> targetInterface;

    public MapperProxyFactory(Class<?> targetInterface) {
        this.targetInterface = targetInterface;
    }
    /**
     * 创建代理对象，并为代理对象传入一个 InvocationHandler 对象
     * 在 MyBatis 中，这个 InvocationHandler 对应的是 MapperProxy，
     * 在这里我们定义的类是 MapperProxyHandler
     * @return
     */
    public Object newInstance(MapperProxyHandler handler){
        return Proxy.newProxyInstance(targetInterface.getClassLoader(), //类加载器
                                        new Class[]{targetInterface},
                                        handler);
    }
}

public class TestMapperProxy {
    public static void main(String[] args) {
        //1. 获取目标接口的类对象
        Class<?> targetInterface = SearchDao.class;
        //2. 获取SqlSession对象
        SqlSession sqlSession = new DefaultSqlSession();
        //3. 创建一个MapperProxyHandler对象
        MapperProxyHandler proxyHandler = new MapperProxyHandler(sqlSession, targetInterface);
        //4. 创建一个MapperProxyFactory对象
        MapperProxyFactory factory = new MapperProxyFactory(SearchDao.class);
        //5. 基于工厂对象为目标接口创建代理对象
        SearchDao searchDao = (SearchDao) factory.newInstance(proxyHandler);
        System.out.println(searchDao.getClass().getName());
        //6. 基于代理对象执行业务操作
        searchDao.search("hello mybatis proxy");
    }
}
