/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.self.memoapp.ejb;

import edu.self.memoapp.entity.Memo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author user
 */
@Stateless
public class MemoFacade extends AbstractFacade<Memo> {
    @PersistenceContext(unitName = "edu.self_MemoApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MemoFacade() {
        super(Memo.class);
    }
    
}
