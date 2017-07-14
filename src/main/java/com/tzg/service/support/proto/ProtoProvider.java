package com.tzg.service.support.proto;

import java.util.List;
import java.util.Map;

public abstract class ProtoProvider< T extends ProtoBean > {

    protected abstract ProtoService getService();

    public void insert( T bean ) throws Exception {
        getService().insert( bean );
    }

    public void delete( Integer id ) throws Exception {
        getService().delete( id );
    }

    public void deleteList( Map< String, Object > map ) throws Exception {
        getService().deleteList( map );
    }

    public void update( T bean ) throws Exception {
        getService().update( bean );
    }

    public T selectById( Integer id ) throws Exception {
        return ( T ) getService().selectById( id );
    }

    public Integer selectCount( Map< String, Object > map ) throws Exception {
        return getService().selectCount( map );
    }

    public List< T > selectList( Map< String, Object > map ) throws Exception {
        return getService().selectList( map );
    }

}
