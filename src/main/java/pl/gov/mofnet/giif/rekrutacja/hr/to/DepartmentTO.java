/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.gov.mofnet.giif.rekrutacja.hr.to;

import java.io.Serializable;

public class DepartmentTO implements Serializable {
    
    private Short id;
    private String name;

    public DepartmentTO() {
    }

    public DepartmentTO(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
