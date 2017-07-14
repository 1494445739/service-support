package com.tzg.service.support.proto;

import com.tzg.service.support.json.JsonResp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ProtoControllerEx< T extends ProtoBean > extends ProtoBaseController {

    protected abstract ProtoProvider getProvider();

    /* =============================================================== */
    /* http方法调用支持。包括post、delete、put、get和index等方法           */
    /* =============================================================== */
    @SuppressWarnings( "unchecked" )
    @ResponseBody
    @RequestMapping( "/proto/post" )
    public JsonResp post( T bean ) throws Exception {
        getProvider().insert( bean );
        return getSuccessJsonResp( bean );
    }

    @ResponseBody
    @RequestMapping( "/proto/delete" )
    public JsonResp delete( Integer id ) throws Exception {
        getProvider().delete( id );
        return getSuccessJsonResp();
    }

    @SuppressWarnings( "unchecked" )
    @ResponseBody
    @RequestMapping( "/proto/deleteList" )
    public JsonResp deleteList( String ids ) throws Exception {

        Map< String, Object > map = new HashMap<>();
        map.put( "ids", Arrays.asList( ids.split( "-" ) ) );

        getProvider().deleteList( map );
        return getSuccessJsonResp();

    }

    @SuppressWarnings( "unchecked" )
    @ResponseBody
    @RequestMapping( "/proto/put" )
    public JsonResp put( T bean ) throws Exception {
        getProvider().update( bean );
        return getSuccessJsonResp();
    }

    @SuppressWarnings( "unchecked" )
    @ResponseBody
    @RequestMapping( "/proto/get" )
    public JsonResp get( Integer id ) throws Exception {
        T t = ( T ) getProvider().selectById( id );
        return getSuccessJsonResp( t, 1 );
    }

    @SuppressWarnings( "unchecked" )
    @ResponseBody
    @RequestMapping( "/proto/index" )
    public JsonResp index( T bean, @RequestParam( value = "pageIndex", required = false ) Integer pageIndex, @RequestParam( value = "pageSize", required = false ) Integer pageSize )
            throws Exception {

        Map< String, Object > map = getPagingQryMap( bean, pageIndex, pageSize );

        Integer   count = getProvider().selectCount( map );
        List< T > list  = getProvider().selectList( map );

        return getSuccessJsonResp( list, count );

    }

}
