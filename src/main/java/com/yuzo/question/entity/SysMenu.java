package com.yuzo.question.entity;

public class SysMenu {
    private String menuId;

    private String menuUrl;

    private String menuName;

    private String menuIslink;

    private Integer menuSequ;

    private String menuPare;

    private String menuState;

    private String menuInfo;

    private String menuIco;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuIslink() {
        return menuIslink;
    }

    public void setMenuIslink(String menuIslink) {
        this.menuIslink = menuIslink == null ? null : menuIslink.trim();
    }

    public Integer getMenuSequ() {
        return menuSequ;
    }

    public void setMenuSequ(Integer menuSequ) {
        this.menuSequ = menuSequ;
    }

    public String getMenuPare() {
        return menuPare;
    }

    public void setMenuPare(String menuPare) {
        this.menuPare = menuPare == null ? null : menuPare.trim();
    }

    public String getMenuState() {
        return menuState;
    }

    public void setMenuState(String menuState) {
        this.menuState = menuState == null ? null : menuState.trim();
    }

    public String getMenuInfo() {
        return menuInfo;
    }

    public void setMenuInfo(String menuInfo) {
        this.menuInfo = menuInfo == null ? null : menuInfo.trim();
    }

    public String getMenuIco() {
        return menuIco;
    }

    public void setMenuIco(String menuIco) {
        this.menuIco = menuIco == null ? null : menuIco.trim();
    }
}