package com.noxue.model;

import com.noxue.domain.Type;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by noxue on 2017/3/31.
 */
public class TypeSub{

    private Type type = null;

    private List<TypeSub> subs=null;

    public TypeSub() {
        type = new Type();
        subs = new ArrayList<TypeSub>();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<TypeSub> getSubs() {
        return subs;
    }

    public void setSubs(List<TypeSub> subs) {
        this.subs = subs;
    }
}
