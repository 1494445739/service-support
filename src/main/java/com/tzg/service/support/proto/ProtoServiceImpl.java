package com.tzg.service.support.proto;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public abstract class ProtoServiceImpl< T extends ProtoBean > implements ProtoService< T > {

    protected abstract ProtoMapper< T > getMapper();

    /**
     * 记录新增
     *
     * @param bean 需持久化的数据对象
     * @throws Exception 数据库访问异常
     */
    @SuppressWarnings( "unchecked" )
    @Override
    public void insert( T bean ) throws Exception {
        getMapper().insert( bean );
    }

    /**
     * 记录删除
     *
     * @param id 要删除记录的主键
     * @throws Exception 数据库访问异常
     */
    @Override
    public void delete( Integer id ) throws Exception {
        getMapper().delete( id );
    }

    /**
     * 记录批量删除
     *
     * @param map 查询条件映射
     * @throws Exception 数据库访问异常
     */
    @Override
    public void deleteList( Map< String, Object > map ) throws Exception {
        getMapper().deleteList( map );
    }

    /**
     * 记录更新
     *
     * @param bean 需持久化的数据对象
     * @throws Exception 数据库访问异常
     */
    @SuppressWarnings( "unchecked" )
    @Override
    public void update( T bean ) throws Exception {
        getMapper().update( bean );
    }

    /**
     * 根据主键查询记录
     *
     * @param id 主键
     * @throws Exception 数据库访问异常
     */
    @SuppressWarnings( "unchecked" )
    @Override
    public T selectById( Integer id ) throws Exception {
        return ( T ) getMapper().selectById( id );
    }

    /**
     * 根据查询条件返回查询结果记录数。一般用于分页查询。
     *
     * @param map 查询条件映射
     * @throws Exception 数据库访问异常
     */
    @Override
    public Integer selectCount( Map< String, Object > map ) throws Exception {
        return getMapper().selectCount( map );
    }

    /**
     * 根据查询条件返回查询结果。
     *
     * @param map 查询条件映射
     * @throws Exception 数据库访问异常
     */
    @SuppressWarnings( "unchecked" )
    @Override
    public List< T > selectList( Map< String, Object > map ) throws Exception {
        return getMapper().selectList( map );
    }

}
