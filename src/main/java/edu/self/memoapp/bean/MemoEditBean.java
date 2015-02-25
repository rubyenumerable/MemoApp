/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.self.memoapp.bean;

import edu.self.memoapp.ejb.MemoFacade;
import edu.self.memoapp.entity.Memo;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import lombok.Getter;

/**
 *
 * @author user
 */
@Named(value = "memoEditBean")
@ViewScoped
public class MemoEditBean implements Serializable {
    
    @Getter
    private Memo editMemo;
    
    @Inject
    private MemoFacade memoFacade;
    
    @PostConstruct
    public void init() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        Integer key = (Integer) flash.get("editMemoId");
        editMemo = memoFacade.find(key);
    }
    
    public void updateMemo() {
        memoFacade.edit(editMemo);
    }
}
