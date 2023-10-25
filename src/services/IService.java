/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import models.Produits;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface IService {
    public void ajouter(Produits p);
    public void modifier(Produits p);
    public void supprimer(int id);

    /**
     *
     * @param p
     * @return
     */
    public Produits getOne(Produits p);
    public List<Produits> getAll(Produits p);
    
}
