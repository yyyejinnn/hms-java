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
    
    public Dishtxt(String menu, String fee){
        this.menu = menu;
        this.fee = fee;
    }

    public String getMenu() {
        return menu;
    }

    public String getFee() {
        return fee;
    }
    
    
}
