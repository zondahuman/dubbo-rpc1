package com.abin.lee.dubbo.rpc.enums;

public enum UserRole {
    DEFAULT(0, "默认"),
    SYSTEM(10, "系统"),
    MANNUAL(20, "人工");

    private int typeId;
    private String typeName;

    UserRole(int typeId, String typeName) {
        this.typeName = typeName;
        this.typeId = typeId;
    }

    public static UserRole getSmallType(int typeId) {
        for (UserRole sourceType : UserRole.values()) {
            if (sourceType.getTypeId() == typeId) {
                return sourceType;
            }
        }
        return null;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getTypeId() {
        return typeId;
    }


}
