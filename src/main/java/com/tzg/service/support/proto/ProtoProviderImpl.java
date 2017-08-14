package com.tzg.service.support.proto;

import java.util.List;
import java.util.Map;

public abstract class ProtoProviderImpl< T extends ProtoBean > implements ProtoProvider< T > {

    protected abstract ProtoService getService();

    @Override
    @SuppressWarnings( "unchecked" )
    public void insert( T bean ) throws Exception {
        getService().insert( bean );
    }

    @Override
    public void delete( Integer id ) throws Exception {
        getService().delete( id );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public void deleteList( Map< String, Object > map ) throws Exception {
        getService().deleteList( map );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public void update( T bean ) throws Exception {
        getService().update( bean );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public T selectById( Integer id ) throws Exception {
        return ( T ) getService().selectById( id );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public Integer selectCount( Map< String, Object > map ) throws Exception {
        return getService().selectCount( map );
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public List< T > selectList( Map< String, Object > map ) throws Exception {
        return getService().selectList( map );
    }

}
