package com.lionel.gereville.ihm;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.lionel.gereville.model.Ville;

public class VilleTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Ville> villes = new ArrayList<>();;
	private String[] columnsHeader = {"nom", "nbhabitant" };

	@Override
	public int getRowCount() {
		return villes.size();
	}

	@Override
	public int getColumnCount() {
		return columnsHeader.length;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnsHeader[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Ville v = villes.get(rowIndex);
		switch (columnIndex){
			case 0: return v.getNom();
			case 1: return v.getNbHabitants();
		}
		return null;
	}
	
	public Ville getVille(int rowIndex){
		return villes.get(rowIndex);
	}
	
	public void addVille(Ville v){
		villes.add(v);
		
		fireTableRowsInserted(villes.size()-1, villes.size()-1);
	}
	
	public void clear(){
		villes.clear();
		
		fireTableDataChanged();
	}

}
