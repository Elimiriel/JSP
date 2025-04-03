package com.member.model;

public class TableDTO {
    private String tableAdmin;
    private String tablePwd;

    /**
     * @return String return the tablePwd
     */
    public String gettablePwd() {
        return tablePwd;
    }

    /**
     * @param tablePwd the tablePwd to set
     */
    public void settablePwd(String tablePwd) {
        this.tablePwd = tablePwd;
    }


    /**
     * @return String return the tableAdmin
     */
    public String getTableAdmin() {
        return tableAdmin;
    }

    /**
     * @param tableAdmin the tableAdmin to set
     */
    public void setTableAdmin(String tableAdmin) {
        this.tableAdmin = tableAdmin;
    }

}
