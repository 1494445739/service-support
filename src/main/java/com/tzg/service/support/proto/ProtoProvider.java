package com.tzg.service.support.proto;

import java.util.List;
import java.util.Map;

public abstract class ProtoProvider< T extends ProtoBean > {

    protected abstract ProtoService getService();

    @SuppressWarnings( "unchecked" )
    public void insert( T bean ) throws Exception {
        getService().insert( bean );
    }

    public void delete( Integer id ) throws Exception {
        getService().delete( id );
    }

    @SuppressWarnings( "unchecked" )
    public void deleteList( Map< String, Object > map ) throws Exception {
        getService().deleteList( map );
    }

    @SuppressWarnings( "unchecked" )
    public void update( T bean ) throws Exception {
        getService().update( bean );
    }

    @SuppressWarnings( "unchecked" )
    public T selectById( Integer id ) throws Exception {
        return ( T ) getService().selectById( id );
    }

    @SuppressWarnings( "unchecked" )
    public Integer selectCount( Map< String, Object > map ) throws Exception {
        return getService().selectCount( map );
    }

    @SuppressWarnings( "unchecked" )
    public List< T > selectList( Map< String, Object > map ) throws Exception {
        return getService().selectList( map );
    }

}
