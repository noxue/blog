package com.noxue.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by noxue on 2017/3/31.
 */
public class TypeSub{

    private List<TypeModel> types = null;

    private TypeSub sub=null;

    public TypeSub() {
        types = new LinkedList<TypeModel>();
    }

    public List<TypeModel> getTypes() {
        return types;
    }

    public void setTypes(List<TypeModel> types) {
        this.types = types;
    }

    public TypeSub getSub() {
        return sub;
    }

    public void setSub(TypeSub sub) {
        this.sub = sub;
    }
}
