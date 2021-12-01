/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms.room;

/**
 *
 * @author LYJ
 */
public class Dishtxt {
    private String menu;
    private String fee;
    
    //dishCustomer.txt
    private String roomIdx;
    private String name;
    private String peopleNum;
    
    public Dishtxt(String menu, String fee){
        this.menu = menu;
        this.fee = fee;
    }
    
    public Dishtxt(String roomIdx, String name, String peopleNum, String menu, String fee){
        this.roomIdx = roomIdx;
        this.name = name;
        this.peopleNum = peopleNum;
        this.menu = menu;
        this.fee = fee;
    }

    public String getMenu() {
        return menu;
    }

    public String getFee() {
        return fee;
    }

    public String getRoomIdx() {
        return roomIdx;
    }

    public String getName() {
        return name;
    }

    public String getPeopleNum() {
        return peopleNum;
    }
    
    
    
}
