package model;

import java.io.Serializable;

public class SocketRequest implements Serializable {

    private ACTION action;
    private Object obj;

    public SocketRequest(ACTION action, Object obj) {
        this.action = action;
        this.obj = obj;
    }

    public enum ACTION
    {
        GET_ORDERS,
        GET_ORDERS_GROUPBY_DEADLINE,
        GET_ORDERS_GROUPBY_STATUS,
        GET_ORDER_BY_ID,
        GET_ASSIGNED_ORDERS,
        GET_UNASSIGNED_ORDERS,
        GET_CLIENTS,
        UPDATE_ORDER,
        DELETE_ORDER,

        GET_PLANT_PROFILE,
        GET_PLANT_LIST,
        GET_PLANT_BY_ID,
        UPDATE_PLANT,
        DELETE_PLANT,
        ADD_PLANT
    }

    public ACTION getAction() {
        return action;
    }

    public void setAction(ACTION action) {
        this.action = action;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}
